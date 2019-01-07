//THIS FILE NEEDS TO BE EDITED BY THE STUDENT

//This class extends the abstract class binaryOperations and should include an
//implementation of the multiplication algorithm. The algorithm that should be
//implemented should be the simple O(n^2) Divide and Conquer algorithm discussed
//in class.

public class Mult2 extends binaryOperations{
    
    public myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2){
        //To be implemented by the student
             
         int size1 = N1.getSize();
        int size2 = N2.getSize();
        int size = size1;
        if(size2 > size1)size = size2;
        int i=0;
        
      myBinaryNumber AL; myBinaryNumber AR; myBinaryNumber BL; myBinaryNumber BR; 
      myBinaryNumber A; myBinaryNumber B;
      myBinaryNumber P; myBinaryNumber Q; myBinaryNumber R; myBinaryNumber S;
      
        A=new myBinaryNumber(size);
        B=new myBinaryNumber(size);
        for(i=0;i<size1;i++)
        {
           try {A.setBit(i , N1.getBit(i));}
                 catch(Exception e){e.printStackTrace();System.exit(0);} 
        }
        
        for(i=0;i<size2;i++)
        {
           try {B.setBit(i , N2.getBit(i));}
                 catch(Exception e){e.printStackTrace();System.exit(0);} 
        }

      

        if(size==1)
        {
        	if(A.getBit(0)==1 && B.getBit(0)==1)
        		return(A);
            if(A.getBit(0)==1 && B.getBit(0)==0)
                return(B);
            if(A.getBit(0)==0 && B.getBit(0)==1)
                return(A);
            return(A);
        	
        }

        if(size%2==0)
        {            AL = new myBinaryNumber(size/2);
        	         AR = new myBinaryNumber(size/2);
                     BL = new myBinaryNumber(size/2);
                     BR = new myBinaryNumber(size/2);
        	for(i=0;i<(size/2);i++){ 
        		 try {AR.setBit(i , A.getBit(i));   }
        		 catch(Exception e){e.printStackTrace();System.exit(0);}
                  try {BR.setBit(i , B.getBit(i));   }
                 catch(Exception e){e.printStackTrace();System.exit(0);}
        		 try {AL.setBit(i,A.getBit((size/2)+i));}
        		 catch(Exception e){e.printStackTrace();System.exit(0);}
                 try {BL.setBit(i,B.getBit((size/2)+i));}
                 catch(Exception e){e.printStackTrace();System.exit(0);}

        	}

        }
        else
        {    
            AL = new myBinaryNumber((size-1)/2);
             AR = new myBinaryNumber((size+1)/2);
            BL = new myBinaryNumber((size-1)/2);
             BR = new myBinaryNumber((size+1)/2);
        	
        	for(i=0;i<((size-1)/2);i++){       
        		try {AR.setBit(i , A.getBit(i));}
        		catch(Exception e){e.printStackTrace();System.exit(0);}
                try {BR.setBit(i , B.getBit(i));}
                catch(Exception e){e.printStackTrace();System.exit(0);}
        		try {AL.setBit(i,A.getBit((size1+1)/2+i));}
        		catch(Exception e){e.printStackTrace();System.exit(0);}
                try {BL.setBit(i,B.getBit((size1+1)/2+i));}
                catch(Exception e){e.printStackTrace();System.exit(0);}
        	}
        	try {AR.setBit(i,A.getBit(i));}
        	catch(Exception e){e.printStackTrace();System.exit(0);}
            try {BR.setBit(i,B.getBit(i));}
            catch(Exception e){e.printStackTrace();System.exit(0);}
        }

       
        P = new myBinaryNumber((AL.getSize()+BL.getSize()));
        Q = new myBinaryNumber((AR.getSize()+BR.getSize()));
        R = new myBinaryNumber((AL.getSize()+BR.getSize()));
        S = new myBinaryNumber((AR.getSize()+BL.getSize()));

        P= multiplication(AL,BL);
        Q= multiplication(AR,BR);
        R= multiplication(AL,BR);
        S= multiplication(AR,BL);
       return(combine(P,Q,R,S,2*size,AR.getSize()));   

        }

    public myBinaryNumber combine (myBinaryNumber P ,myBinaryNumber Q ,myBinaryNumber R ,myBinaryNumber S ,int size , int size3 )
    {
     myBinaryNumber x= new myBinaryNumber(size);
     myBinaryNumber y= new myBinaryNumber(P.getSize()+size3*2);
     myBinaryNumber z= new myBinaryNumber(R.getSize()+size3);
     myBinaryNumber w= new myBinaryNumber(S.getSize()+size3);
     y= shift(P,size3*2);
     z=shift(R,size3);
     w=shift(S,size3);
     x=addition(x,Q);
     x=addition(x,y);
     x=addition(x,z);
     x=addition(x,w);
     return(x);
    }
    public myBinaryNumber shift (myBinaryNumber A, int shift_factor)
    {
		int i=0;
		myBinaryNumber B= new myBinaryNumber(A.getSize()+shift_factor);
    	for (i=0;i<A.getSize();i++)
    	{
    		try {B.setBit(i+shift_factor,A.getBit(i));}
    		catch(Exception e){e.printStackTrace();System.exit(0);}
    	}
    	return(B);
    } 
}
