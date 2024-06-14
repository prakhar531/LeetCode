// class Solution {
//     public int minIncrementForUnique(int[] nums) {
//         Arrays.sort(nums);
//         int ans=0;
//         for(int i=1;i<nums.length;i++){
//             while(nums[i]<=nums[i-1]){
//                 nums[i]++;
//                 ans++;
                
//             }
//         }
//         return ans;
//     }
// }

// class Solution {

//     public int minIncrementForUnique(int[] nums) {
//         int minIncrements = 0;

//         Arrays.sort(nums);

//         for (int i = 1; i < nums.length; i++) {
//             // Ensure each element is greater than its previous
//             if (nums[i] <= nums[i - 1]) {
//                 // Add the required increment to minIncrements
//                 int increment = nums[i - 1] + 1 - nums[i];
//                 minIncrements += increment;

//                 // Set the element to be greater than its previous
//                 nums[i] = nums[i - 1] + 1;
//             }
//         }

//         return minIncrements;
//     }
// }

class Solution {

    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int max = 0;
        int minIncrements = 0;

        // Find maximum value in array to determine range of frequencyCount array
        for (int val : nums) {
            max = Math.max(max, val);
        }

        // Create a frequencyCount array to store the frequency of each value in nums
        int[] frequencyCount = new int[n + max];

        // Populate frequencyCount array with the frequency of each value in nums
        for (int val : nums) {
            frequencyCount[val]++;
        }

        // Iterate over the frequencyCount array to make all values unique
        for (int i = 0; i < frequencyCount.length; i++) {
            if (frequencyCount[i] <= 1) continue;

            // Determine excess occurrences, carry them over to the next value,
            // ensure single occurrence for current value, and update minIncrements.
            int duplicates = frequencyCount[i] - 1;
            frequencyCount[i + 1] += duplicates;
            frequencyCount[i] = 1;
            minIncrements += duplicates;
        }

        return minIncrements;
    }
}