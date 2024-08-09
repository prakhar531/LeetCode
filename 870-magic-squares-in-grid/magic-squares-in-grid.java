class Solution {

    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int row = 0; row + 2 < m; row++) {
            for (int col = 0; col + 2 < n; col++) {
                if (isMagicSquare(grid, row, col)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9) return false;
                if (seen[num]) return false;
                seen[num] = true;
            }
        }

        // check if diagonal sums are same value
        int diagonal1 =
            grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int diagonal2 =
            grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];

        if (diagonal1 != diagonal2) return false;

        // check if all row sums share the same value as the diagonal sums
        int row1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int row2 =
            grid[row + 1][col] +
            grid[row + 1][col + 1] +
            grid[row + 1][col + 2];
        int row3 =
            grid[row + 2][col] +
            grid[row + 2][col + 1] +
            grid[row + 2][col + 2];

        if (!(row1 == diagonal1 && row2 == diagonal1 && row3 == diagonal1)) {
            return false;
        }

        // check if all column sums share same value as the diagonal sums
        int col1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int col2 =
            grid[row][col + 1] +
            grid[row + 1][col + 1] +
            grid[row + 2][col + 1];
        int col3 =
            grid[row][col + 2] +
            grid[row + 1][col + 2] +
            grid[row + 2][col + 2];

        if (!(col1 == diagonal1 && col2 == diagonal1 && col3 == diagonal2)) {
            return false;
        }

        return true;
    }
}

// class Solution {

//     public int numMagicSquaresInside(int[][] grid) {
//         int ans = 0;
//         int m = grid.length;
//         int n = grid[0].length;
//         for (int row = 0; row + 2 < m; row++) {
//             for (int col = 0; col + 2 < n; col++) {
//                 if (isMagicSquare(grid, row, col)) {
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }

//     private boolean isMagicSquare(int[][] grid, int row, int col) {
//         // The sequences are each repeated twice to account for
//         // the different possible starting points of the sequence
//         // in the magic square
//         String sequence = "2943816729438167";
//         String sequenceReversed = "7618349276183492";

//         StringBuilder border = new StringBuilder();
//         // Flattened indices for bordering elements of 3x3 grid
//         int[] borderIndices = new int[] { 0, 1, 2, 5, 8, 7, 6, 3 };
//         for (int i : borderIndices) {
//             int num = grid[row + i / 3][col + (i % 3)];
//             border.append(num);
//         }

//         String borderConverted = border.toString();

//         // Make sure the sequence starts at one of the corners
//         return (
//             grid[row][col] % 2 == 0 &&
//             (sequence.contains(borderConverted) ||
//                 sequenceReversed.contains(borderConverted)) &&
//             grid[row + 1][col + 1] == 5
//         );
//     }
// }