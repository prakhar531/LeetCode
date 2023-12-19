class Solution {
    public int maxProductDifference(int[] nums) {
        int[] cloneNums = Arrays.copyOf(nums, nums.length);
        int[] fmaxmin = getMaxMin(cloneNums);
        int[] smaxmin = getMaxMin(cloneNums);

        return fmaxmin[0] * smaxmin[0] - fmaxmin[1] * smaxmin[1];
    }

    private int[] getMaxMin(int[] nums) {
        int len = nums.length;
        int maxi = 0, mini = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxi = i;
            }
            if (nums[i] < min && nums[i] != Integer.MIN_VALUE) {
                min = nums[i];
                mini = i;
            }
        }
        nums[maxi] = Integer.MIN_VALUE;
        nums[mini] = Integer.MIN_VALUE;
        return new int[] {max, min};
    }
}