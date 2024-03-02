class Solution {
    public int[] sortedSquares(int[] nums) {

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1 || nums[i]==0){
                nums[i]=nums[i];
                continue;
            }
            nums[i]=(int)Math.pow(nums[i],2);
        }
        Arrays.sort(nums);
        return nums;
        
    }
}