class Solution {

    public int minDifference(int[] nums) {
        int numsSize = nums.length;

        // If the array has 4 or fewer elements, return 0
        if (numsSize <= 4) return 0;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        // Four scenarios to compute the minimum difference
        for (int left = 0, right = numsSize - 4; left < 4; left++, right++) {
            minDiff = Math.min(minDiff, nums[right] - nums[left]);
        }

        return minDiff;
    }
}