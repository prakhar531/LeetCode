class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        for(int num:nums) max=Math.max(num,max);
        long ans=0;
        int count=0;

        for(int left=0,right=0;right<nums.length;right++){
            if(nums[right]==max) count++;
            while(count==k){
                if(nums[left]==max) count--;
                left++;
            }
            ans+=left;
        }
        return ans;
    }
}