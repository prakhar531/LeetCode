import java.util.Arrays;

class Solution {
    final int mod = (int) Math.pow(10, 9) + 7;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return recursion(dp, n, k, target);
    }

    private int recursion(int[][] dp, int n, int k, int target) {
        if (target == 0 && n == 0) return 1;
        if (n == 0 || target <= 0) return 0;

        if (dp[n][target] != -1) return (int) (dp[n][target] % mod);
        int ways = 0;
        for (int i = 1; i <= k; i++) {
            ways = (ways + recursion(dp, n - 1, k, target - i)) % mod;
        }
        dp[n][target] = ways % mod;
        return dp[n][target];
    }
}

