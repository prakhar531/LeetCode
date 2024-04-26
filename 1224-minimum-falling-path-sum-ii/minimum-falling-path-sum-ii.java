class Solution {
    public int minFallingPathSum(int[][] grid) {
        // Initialize a two-dimensional array to cache the result of each sub-problem
        int[][] memo = new int[grid.length][grid.length];

        // Minimum and Second Minimum Column Index
        int nextMin1C = -1;
        int nextMin2C = -1;

        // Base Case. Fill and save the minimum and second minimum column index
        for (int col = 0; col < grid.length; col++) {
            memo[grid.length - 1][col] = grid[grid.length - 1][col];
            if (nextMin1C == -1 || memo[grid.length - 1][col] <= memo[grid.length - 1][nextMin1C]) {
                nextMin2C = nextMin1C;
                nextMin1C = col;
            } else if (nextMin2C == -1 || memo[grid.length - 1][col] <= memo[grid.length - 1][nextMin2C]) {
                nextMin2C = col;
            }
        }

        // Fill the recursive cases
        for (int row = grid.length - 2; row >= 0; row--) {
            // Minimum and Second Minimum Column Index of the current row
            int min1C = -1;
            int min2C = -1;

            for (int col = 0; col < grid.length; col++) {
                // Select minimum from valid cells of the next row
                if (col != nextMin1C) {
                    memo[row][col] = grid[row][col] + memo[row + 1][nextMin1C];
                } else {
                    memo[row][col] = grid[row][col] + memo[row + 1][nextMin2C];
                }

                // Save minimum and second minimum column index
                if (min1C == -1 || memo[row][col] <= memo[row][min1C]) {
                    min2C = min1C;
                    min1C = col;
                } else if (min2C == -1 || memo[row][col] <= memo[row][min2C]) {
                    min2C = col;
                }
            }

            // Change of row. Update nextMin1C and nextMin2C
            nextMin1C = min1C;
            nextMin2C = min2C;
        }

        // Return the minimum from the first row
        return memo[0][nextMin1C];
    }
}