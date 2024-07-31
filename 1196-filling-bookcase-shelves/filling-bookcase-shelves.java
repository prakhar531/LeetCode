// class Solution {

//     public int minHeightShelves(int[][] books, int shelfWidth) {
//         // Cache to store previous computations
//         int[][] memo = new int[books.length][shelfWidth + 1];
//         return dpHelper(books, shelfWidth, memo, 0, shelfWidth, 0);
//     }

//     private int dpHelper(
//         int[][] books,
//         int shelfWidth,
//         int[][] memo,
//         int i,
//         int remainingShelfWidth,
//         int maxHeight
//     ) {
//         int[] currentBook = books[i];
//         int maxHeightUpdated = Math.max(maxHeight, currentBook[1]);
//         if (i == books.length - 1) {
//             // For the last book, store it in the current shelf if possible,
//             // or start a new shelf with it
//             if (remainingShelfWidth >= currentBook[0]) return maxHeightUpdated;
//             return maxHeight + currentBook[1];
//         }
//         // Return answer if already computed
//         if (memo[i][remainingShelfWidth] != 0) {
//             return memo[i][remainingShelfWidth];
//         } else {
//             // Calculate the height of the bookcase if we put the current book on the new shelf
//             int option1Height =
//                 maxHeight +
//                 dpHelper(
//                     books,
//                     shelfWidth,
//                     memo,
//                     i + 1,
//                     shelfWidth - currentBook[0],
//                     currentBook[1]
//                 );
//             if (remainingShelfWidth >= currentBook[0]) {
//                 // Calculate height of the bookcase if we put the current book on the current shelf
//                 int option2Height = dpHelper(
//                     books,
//                     shelfWidth,
//                     memo,
//                     i + 1,
//                     remainingShelfWidth - currentBook[0],
//                     maxHeightUpdated
//                 );
//                 // Store result in cache
//                 memo[i][remainingShelfWidth] = Math.min(
//                     option1Height,
//                     option2Height
//                 );
//                 return memo[i][remainingShelfWidth];
//             }
//             // Store result in cache
//             memo[i][remainingShelfWidth] = option1Height;
//             return memo[i][remainingShelfWidth];
//         }
//     }
// }

class Solution {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        // dp[i] = minimum height of bookcase containing all books up to and
        // excluding book i
        int[] dp = new int[books.length + 1];

        // base cases
        dp[0] = 0;
        dp[1] = books[0][1];

        for (int i = 2; i <= books.length; i++) {
            // new shelf built to hold current book
            int remainingShelfWidth = shelfWidth - books[i - 1][0];
            int maxHeight = books[i - 1][1];
            dp[i] = books[i - 1][1] + dp[i - 1];

            int j = i - 1;
            // calculate the height when previous books are added onto a new shelf
            while (j > 0 && remainingShelfWidth - books[j - 1][0] >= 0) {
                maxHeight = Math.max(maxHeight, books[j - 1][1]);
                remainingShelfWidth -= books[j - 1][0];
                dp[i] = Math.min(dp[i], maxHeight + dp[j - 1]);
                j--;
            }
        }

        return dp[books.length];
    }
}