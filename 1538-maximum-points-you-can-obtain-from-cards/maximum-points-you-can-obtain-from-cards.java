class Solution {
    public int maxScore(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++) sum+=nums[i];
        int ans=sum;

        for(int i=k-1,j=nums.length-1;i>=0;i--,j--){
            sum-=nums[i];
            sum+=nums[j];
            ans=Math.max(ans,sum);
        }
        return ans;
    }
        
}