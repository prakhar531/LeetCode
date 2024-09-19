class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        // Create a 2D array of lists to store results of subproblems
        List<Integer>[][] dp = new ArrayList[n][n];

        initializeBaseCases(expression, dp);

        // Fill the dp table for all possible subexpressions
        for (int length = 3; length <= n; length++) {
            for (int start = 0; start + length - 1 < n; start++) {
                int end = start + length - 1;
                processSubexpression(expression, dp, start, end);
            }
        }

        // Return the results for the entire expression
        return dp[0][n - 1];
    }

    private void initializeBaseCases(String expression, List<Integer>[][] dp) {
        int n = expression.length();
        // Initialize the dp array with empty lists
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }

        // Handle base cases: single digits and two-digit numbers
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(expression.charAt(i))) {
                // Check if it's a two-digit number
                int dig1 = expression.charAt(i) - '0';
                if (i + 1 < n && Character.isDigit(expression.charAt(i + 1))) {
                    int dig2 = expression.charAt(i + 1) - '0';
                    int number = dig1 * 10 + dig2;
                    dp[i][i + 1].add(number);
                }
                // Single digit case
                dp[i][i].add(dig1);
            }
        }
    }

    private void processSubexpression(
        String expression,
        List<Integer>[][] dp,
        int start,
        int end
    ) {
        // Try all possible positions to split the expression
        for (int split = start; split <= end; split++) {
            if (Character.isDigit(expression.charAt(split))) continue;

            List<Integer> leftResults = dp[start][split - 1];
            List<Integer> rightResults = dp[split + 1][end];

            computeResults(
                expression.charAt(split),
                leftResults,
                rightResults,
                dp[start][end]
            );
        }
    }

    private void computeResults(
        char op,
        List<Integer> leftResults,
        List<Integer> rightResults,
        List<Integer> results
    ) {
        // Compute results based on the operator at position 'split'
        for (int leftValue : leftResults) {
            for (int rightValue : rightResults) {
                switch (op) {
                    case '+':
                        results.add(leftValue + rightValue);
                        break;
                    case '-':
                        results.add(leftValue - rightValue);
                        break;
                    case '*':
                        results.add(leftValue * rightValue);
                        break;
                }
            }
        }
    }
}