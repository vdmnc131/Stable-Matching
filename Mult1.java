
//THIS FILE NEEDS TO BE EDITED BY THE STUDENT

//This class extends the abstract class binaryOperations and should include an
//implementation of the multiplication algorithm. The algorithm that should be
//implemented is the simple O(n^2) Long Multiplication algorithm discussed
//in class.

public class Mult1 extends binaryOperations{
    
    public myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2){
        //To be implemented by the student
         int size1 = N1.getSize();
        int size2 = N2.getSize();
        int size = size1;
        if(size2 > size1)size = size2;
       //System.out.println(size2);
        //Create an all 0's binary number of size*2
        myBinaryNumber N = new myBinaryNumber(1);
        myBinaryNumber x ;
      //  N.printNumber();
        int position,i,val;
        val=0;i=0;position=0;
        	for(position=0;position<size2;position++)
        	{   
        		if(N2.getBit(position)==1)

        		{ 
        		      x= new myBinaryNumber(size1+size2-1);    
                    for(i=0;i<size1;i++)
        			{
        				val=N1.getBit(i);
                        try{
                        x.setBit(position+i , val);
                            }
                        catch(Exception e){e.printStackTrace();System.exit(0);}
        			}
                  N=addition(N,x);
                  
        		}
        		
        		

        		
        	}

        	return(N);
    }
}