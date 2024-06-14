class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=1;i<nums.length;i++){
            while(nums[i]<=nums[i-1]){
                nums[i]++;
                ans++;
                
            }
        }
        return ans;
    }
}