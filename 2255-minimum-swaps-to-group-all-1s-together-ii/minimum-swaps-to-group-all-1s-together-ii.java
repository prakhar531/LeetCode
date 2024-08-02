class Solution {
    public int minSwaps(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int total=0;
        for(int num:nums){
            total+=num;
        }
        int curr=nums[0];
        int end=0;
        for(int start=0;start<nums.length;start++){
            if(start!=0) curr-=nums[start-1];
            while(end-start+1<total){
                end++;
                curr+=nums[end%nums.length];
            }
            ans=Math.min(ans,total-curr);
        }
        return ans;
    }
}