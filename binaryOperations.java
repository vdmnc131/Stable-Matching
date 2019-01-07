//THIS CLASS SHOULD BE USED AS IT IS AND SHOULD NOT BE MODIFIED IN ANY MANNER

abstract class binaryOperations{
    
    //Given an n-bit number and an m-bit number, the method below outputs a binary number
    //of size max{n, m}+1 which is the sum of the given numbers
    public myBinaryNumber addition(myBinaryNumber N1, myBinaryNumber N2){
        //Find the size of the numbers
        int size1 = N1.getSize();
        int size2 = N2.getSize();
        int size = size1;
        if(size2 > size1)size = size2;
        
        //Create an all 0's binary number of size size+1
        myBinaryNumber N = new myBinaryNumber(size+1);
        
        int position;
        int sum, carry = 0;
        for(position = 0; position < size;++position){
            sum = N1.getBit(position) + N2.getBit(position) + carry;
            try{
              N.setBit(position, sum%2);
            }catch(Exception e){e.printStackTrace();System.exit(0);}
            carry = sum/2;
        }
        try{
            N.setBit(position, carry);
        }catch(Exception e){e.printStackTrace();System.exit(0);}
        
        return(N);
    }

    public boolean smaller(myBinaryNumber N1 , myBinaryNumber N2)
    {
        N1=ZERO(N1);
        N2=ZERO(N2);
        int size1=0;
        int size2=0;
        size1=N1.getSize();
        size2=N2.getSize();

        if(size1<size2) return(true); 
        if(size2>size1) return(false);
        for(int i=size1-1;i>=0;i--)
        {
            if(N1.getBit(i)==1 && N2.getBit(i)==0)
            {
                return(false);
            }
           if(N1.getBit(i)==0 && N2.getBit(i)==1)
           {
            return(true);
           }
        }
        return(false);
        

    }

      public myBinaryNumber ZERO(myBinaryNumber A){
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
    
    
    //Given an n-bit number and an m-bit number, the method below should return an
    //(n+m)-bit number which is the product of the given numbers.
    abstract myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2);
}