class Solution {

    public int stoneGameII(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length + 1][length + 1];

        // Store suffix sum for all possible suffix
        int[] suffixSum = new int[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // Initialize the dp array.
        for (int i = 0; i <= length; i++) {
            dp[i][length] = suffixSum[i];
        }

        // Start from the last index to store the future state first.
        for (int index = length - 1; index >= 0; index--) {
            for (int maxTillNow = length - 1; maxTillNow >= 1; maxTillNow--) {
                for (
                    int X = 1;
                    X <= 2 * maxTillNow && index + X <= length;
                    X++
                ) {
                    dp[index][maxTillNow] = Math.max(
                        dp[index][maxTillNow],
                        suffixSum[index] -
                        dp[index + X][Math.max(maxTillNow, X)]
                    );
                }
            }
        }
        return dp[0][1];
    }
}