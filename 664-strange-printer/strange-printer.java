// class Solution {

//     public int strangePrinter(String s) {
//         // Preprocess the string to remove consecutive duplicate characters
//         s = removeDuplicates(s);

//         int n = s.length();

//         // dp[i][j] represents the minimum number of turns to print s[i] to s[j]
//         int[][] minTurns = new int[n][n];

//         // Initialize base case
//         for (int i = 0; i < n; i++) {
//             // It takes 1 turn to print a single character
//             minTurns[i][i] = 1;
//         }

//         // Fill the dp table
//         for (int length = 2; length <= n; length++) {
//             for (int start = 0; start + length - 1 < n; start++) {
//                 int end = start + length - 1;

//                 // Initialize with worst case: print each character separately
//                 minTurns[start][end] = length;

//                 // Try all possible splits and find the minimum
//                 for (int split = 0; split < length - 1; split++) {
//                     int totalTurns =
//                         minTurns[start][start + split] +
//                         minTurns[start + split + 1][end];

//                     // If the characters at the split and end match, we can save one turn
//                     if (s.charAt(start + split) == s.charAt(end)) {
//                         totalTurns--;
//                     }

//                     minTurns[start][end] = Math.min(
//                         minTurns[start][end],
//                         totalTurns
//                     );
//                 }
//             }
//         }

//         // Return the minimum turns needed to print the entire string
//         return minTurns[0][n - 1];
//     }

//     private String removeDuplicates(String s) {
//         StringBuilder uniqueChars = new StringBuilder();
//         int i = 0;
//         while (i < s.length()) {
//             char currentChar = s.charAt(i);
//             uniqueChars.append(currentChar);
//             // Skip all consecutive occurrences of the current character
//             while (i < s.length() && s.charAt(i) == currentChar) {
//                 i++;
//             }
//         }
//         return uniqueChars.toString();
//     }
// }

class Solution {

    public int strangePrinter(String s) {
        // Preprocess the string to remove consecutive duplicate characters
        s = removeDuplicates(s);
        int n = s.length();
        // Initialize memoization array
        Integer[][] memo = new Integer[n][n];
        // Start the recursive process
        return minimumTurns(0, n - 1, s, memo);
    }

    private int minimumTurns(int start, int end, String s, Integer[][] memo) {
        // Base case: empty string requires 0 turns
        if (start > end) {
            return 0;
        }

        // If result is memoized, return it
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        // Initialize with worst case: print each character separately
        int minTurns = 1 + minimumTurns(start + 1, end, s, memo);

        // Try to optimize by finding matching characters
        for (int k = start + 1; k <= end; k++) {
            if (s.charAt(k) == s.charAt(start)) {
                // If match found, try splitting the problem
                int turnsWithMatch =
                    minimumTurns(start, k - 1, s, memo) +
                    minimumTurns(k + 1, end, s, memo);
                minTurns = Math.min(minTurns, turnsWithMatch);
            }
        }

        // Memoize and return the result
        return memo[start][end] = minTurns;
    }

    private String removeDuplicates(String s) {
        StringBuilder uniqueChars = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            uniqueChars.append(currentChar);
            // Skip all consecutive occurrences of the current character
            while (i < s.length() && s.charAt(i) == currentChar) {
                i++;
            }
        }
        return uniqueChars.toString();
    }
}