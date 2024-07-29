// class Solution {

//     public int numTeams(int[] rating) {
//         int n = rating.length;
//         int teams = 0;

//         // Tables for increasing and decreasing sequences
//         int[][] increasingTeams = new int[n][4];
//         int[][] decreasingTeams = new int[n][4];

//         // Fill the base cases. (Each soldier is a sequence of length 1)
//         for (int i = 0; i < n; i++) {
//             increasingTeams[i][1] = 1;
//             decreasingTeams[i][1] = 1;
//         }

//         // Fill the tables
//         for (int count = 2; count <= 3; count++) {
//             for (int i = 0; i < n; i++) {
//                 for (int j = i + 1; j < n; j++) {
//                     if (rating[j] > rating[i]) {
//                         increasingTeams[j][count] +=
//                         increasingTeams[i][count - 1];
//                     }
//                     if (rating[j] < rating[i]) {
//                         decreasingTeams[j][count] +=
//                         decreasingTeams[i][count - 1];
//                     }
//                 }
//             }
//         }

//         // Sum up the results (All sequences of length 3)
//         for (int i = 0; i < n; i++) {
//             teams += increasingTeams[i][3] + decreasingTeams[i][3];
//         }

//         return teams;
//     }
// }

// class Solution {

//     public int numTeams(int[] rating) {
//         int n = rating.length;
//         int teams = 0;

//         // Iterate through each soldier as the middle soldier
//         for (int mid = 0; mid < n; mid++) {
//             int leftSmaller = 0;
//             int rightLarger = 0;

//             // Count soldiers with smaller rating on the left side of the current soldier
//             for (int left = mid - 1; left >= 0; left--) {
//                 if (rating[left] < rating[mid]) {
//                     leftSmaller++;
//                 }
//             }

//             // Count soldiers with larger ratings on the right side of the current soldier
//             for (int right = mid + 1; right < n; right++) {
//                 if (rating[right] > rating[mid]) {
//                     rightLarger++;
//                 }
//             }

//             // Calculate and add the number of ascending rating teams (small-mid-large)
//             teams += leftSmaller * rightLarger;

//             // Calculate soldiers with larger ratings on the left and smaller ratings on the right
//             int leftLarger = mid - leftSmaller;
//             int rightSmaller = n - mid - 1 - rightLarger;

//             // Calculate and add the number of descending rating teams (large-mid-small)
//             teams += leftLarger * rightSmaller;
//         }

//         // Return the total number of valid teams
//         return teams;
//     }
// }

class Solution {

    public int numTeams(int[] rating) {
        // Find the maximum rating
        int maxRating = 0;
        for (int r : rating) {
            maxRating = Math.max(maxRating, r);
        }

        // Initialize Binary Indexed Trees for left and right sides
        int[] leftBIT = new int[maxRating + 1];
        int[] rightBIT = new int[maxRating + 1];

        // Populate the right BIT with all ratings initially
        for (int r : rating) {
            updateBIT(rightBIT, r, 1);
        }

        int teams = 0;
        for (int currentRating : rating) {
            // Remove current rating from right BIT
            updateBIT(rightBIT, currentRating, -1);

            // Count soldiers with smaller and larger ratings on both sides
            int smallerRatingsLeft = getPrefixSum(leftBIT, currentRating - 1);
            int smallerRatingsRight = getPrefixSum(rightBIT, currentRating - 1);
            int largerRatingsLeft =
                getPrefixSum(leftBIT, maxRating) -
                getPrefixSum(leftBIT, currentRating);
            int largerRatingsRight =
                getPrefixSum(rightBIT, maxRating) -
                getPrefixSum(rightBIT, currentRating);

            // Count increasing and decreasing sequences
            teams += (smallerRatingsLeft * largerRatingsRight);
            teams += (largerRatingsLeft * smallerRatingsRight);

            // Add current rating to left BIT
            updateBIT(leftBIT, currentRating, 1);
        }

        return teams;
    }

    // Update the Binary Indexed Tree
    private void updateBIT(int[] BIT, int index, int value) {
        while (index < BIT.length) {
            BIT[index] += value;
            index += index & (-index); // Move to the next relevant index in BIT
        }
    }

    // Get the sum of all elements up to the given index in the BIT
    private int getPrefixSum(int[] BIT, int index) {
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index); // Move to the parent node in BIT
        }
        return sum;
    }
}