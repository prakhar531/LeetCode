class Solution {
    public int getSum(int nums){
        int sum=0;
        while(nums!=0){
            sum+=(nums%10);
            nums/=10;
        }
        return sum;
    }
    public int getLucky(String s, int k) {
        int ans=0;
        for(char ch:s.toCharArray()){
            ans+=getSum(ch-'a'+1);
        }
        if(k==1) return ans;
        while(k!=1){
            ans=getSum(ans);
            k--;
        }
        return ans;
        
    }
}