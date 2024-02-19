class Solution {
    public boolean isPowerOfTwo(int n) {
        // if(n<=0) return false;
        // int count=0;
        // while(n!=0){
        //     if((n&1)!=0){
        //         count++;
        //     }
        //     n=(n>>>1);
        // }
        // if(count>1) return false;
        // return true;

        return n>0 && (n&(n-1))==0;


        // return n>0 && Integer.bitCount(n) == 1;
        
    }
}