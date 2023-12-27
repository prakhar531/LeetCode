import java.util.Arrays;

public class Solution {
    public int minCost(String colorSequence, int[] timeRequired) {
        int n = colorSequence.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        char previousColor = 'A';
        int previousTime = 0;

        for (int i = 1; i <= n; i++) {
            if (colorSequence.charAt(i - 1) == previousColor) {
                dp[i] = dp[i - 1] + Math.min(timeRequired[i - 1], previousTime);
                previousTime = Math.max(timeRequired[i - 1], previousTime);
            } else {
                dp[i] = dp[i - 1];
                previousColor = colorSequence.charAt(i - 1);
                previousTime = timeRequired[i - 1];
            }
        }

        return dp[n];
    }
}