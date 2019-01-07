//THIS FILE NEEDS TO BE EDITED BY THE STUDENT

//This class extends the abstract class binaryOperations and should include an
//implementation of the multiplication algorithm. The algorithm that should be
//implemented should be the O(n^{log 3}) Karatsuba algorithm discussed
//in class.

public class Mult3 extends binaryOperations{
    
    public myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2){
        //To be implemented by the student

    	 int size1 = N1.getSize();
        int size2 = N2.getSize();
        int size = size1;
        if(size2 > size1)
        	size = size2;
        int i=0;
        int counter=0; int counter2=0;
        
      myBinaryNumber AL; myBinaryNumber AR; myBinaryNumber BL; myBinaryNumber BR; 
      myBinaryNumber A; myBinaryNumber B;
      myBinaryNumber P; myBinaryNumber Q; myBinaryNumber R; 
      myBinaryNumber D; myBinaryNumber F; 
      
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
        		return(A);	//return (new myBinaryNumber("0"));
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

      
        D = addition(AL,AR);
        F = addition(BL,BR);
       
        
        P= multiplication(AL,BL);
        Q= multiplication(AR,BR);
       
        
      	R= multiplication(REMOVE(D),REMOVE(F));
        return (combine(P,Q,R,2*size,AR.getSize())); 

        
    }
      public myBinaryNumber combine (myBinaryNumber P ,myBinaryNumber Q ,myBinaryNumber R ,int size , int size3 )
    {
     myBinaryNumber x= new myBinaryNumber(size);
     myBinaryNumber y= new myBinaryNumber(P.getSize()+size3*2); myBinaryNumber z; myBinaryNumber w; 
      
     y= shift(P,size3*2);
    x=addition(x,Q);
     x=addition(x,y);
     z=addition(P,Q);

    w=subtraction(R,z);
    myBinaryNumber q= new myBinaryNumber(w.getSize()+size3);
    q=shift(w,size3);
    x=addition(x,q);
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
     public myBinaryNumber subtraction (myBinaryNumber A, myBinaryNumber B)
    {
    	A = REMOVE(A);
    	B = REMOVE(B);
		int size1 = A.getSize(); int i=0;int counter =0;
        
         myBinaryNumber D= new myBinaryNumber(size1);
         myBinaryNumber E =new myBinaryNumber(size1);
         myBinaryNumber F ;
    	
         for(i=0;i<size1;i++)
         {
         	try{D.setBit(i,B.getBit(i));}
         	catch(Exception e){e.printStackTrace();System.exit(0);}
         }
         for(i=0;i<size1;i++)
         {
         	if(D.getBit(i)==1){
         	try {
         		E.setBit(i,0);
         	}
         	catch(Exception e){e.printStackTrace();System.exit(0);}
         					}
         	else{
         		try{ E.setBit(i,1);
         		}
         		catch(Exception e){e.printStackTrace();System.exit(0);}
         		}
         }

         F=addition(addition(E,new myBinaryNumber("1")), A);
        
        for(i = size1; i<F.getSize(); i++){
        	try{
        		F.setBit(i, 0);
        	}
        	catch(Exception e){
        							e.printStackTrace();System.exit(0);
        	}
        }
        return F;

    } 

    public myBinaryNumber REMOVE(myBinaryNumber A){
    	int counter = 0;
    	for(int i = A.getSize()-1; i>=0;i--){
    		if(A.getBit(i)==0)
    			counter++;
    		else
    			i=-1;
    	}
    	if(counter==A.getSize()){
    		myBinaryNumber unit;
    		unit = new myBinaryNumber("0");
    		return unit;
    	}
    	myBinaryNumber B = new myBinaryNumber(A.getSize()-counter);
    	for(int i = 0; i < B.getSize(); i++){
    		try{
    			B.setBit(i, A.getBit(i));
    		}
    		catch(Exception e){
    				e.printStackTrace();System.exit(0);
    		}
    	}
    	return B;
    }


}