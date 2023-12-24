class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i+=2){
            ans[i]=nums[i+1];
            ans[i+1]=nums[i];
        }
        return ans;
    }
}