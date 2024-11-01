class Solution {
    public int divide(int dividend, int divisor) {
    if(dividend==divisor){
        return 1;
    }
    boolean sign=true;

    //Case when the quotient is negative
    if(dividend>=0 && divisor<0){
        sign=false;
    }
    else if(dividend<0 && divisor>0){
        sign=false;
    }

    long n=Math.abs((long)dividend);
    long d=Math.abs((long)divisor);

    long quotient=0;

    while(n>=d){
        int count=0;
        while(n>=(d<<(count+1))){
            count+=1;
        }
        quotient+=(1<<count);
        n-=(d<<count);
    }

    //Overflow Case
    if(quotient==(1<<31)&& sign){
        return Integer.MAX_VALUE;
    }

    //Underflow Case
    if(quotient==(1<<31)&& !sign){
        return Integer.MIN_VALUE;
    }

    return (int) (sign?quotient:-quotient);
    }
}
