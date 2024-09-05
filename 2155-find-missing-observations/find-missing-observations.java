class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m=rolls.length;
        int rollSum=0;
        for(int it:rolls) rollSum+=it;
        int sum=(n+m)*mean-rollSum;
        int ans[]=new int[n];
        if(sum>n*6||sum<n) return new int[]{};

        int avg=sum/n;
        int rem=sum%n;
        for(int i=0;i<n;i++){
            ans[i]=avg;
            if(rem!=0){
                ans[i]++;
                rem--;
            }
        }
        return ans;
    }
}