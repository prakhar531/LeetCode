// class Solution {

//     public int[][] spiralMatrix(int m, int n, ListNode head) {
//         // Store the east, south, west, north movements in a matrix.
//         int i = 0, j = 0, cur_d = 0, movement[][] = {
//             { 0, 1 },
//             { 1, 0 },
//             { 0, -1 },
//             { -1, 0 },
//         };
//         int[][] res = new int[m][n];
//         for (int[] row : res) {
//             Arrays.fill(row, -1);
//         }

//         while (head != null) {
//             res[i][j] = head.val;
//             int newi = i + movement[cur_d][0], newj = j + movement[cur_d][1];

//             // If we bump into an edge or an already filled cell, change the
//             // direction.
//             if (
//                 Math.min(newi, newj) < 0 ||
//                 newi >= m ||
//                 newj >= n ||
//                 res[newi][newj] != -1
//             ) cur_d = (cur_d + 1) % 4;
//             i += movement[cur_d][0];
//             j += movement[cur_d][1];

//             head = head.next;
//         }

//         return res;
//     }
// }

class Solution {
    public int[][] spiralMatrix(int rows, int columns, ListNode head) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int [columns];
            Arrays.fill(matrix[i], -1);
        }

        int topRow = 0, bottomRow = rows - 1, leftColumn = 0, rightColumn = columns - 1;
        while (head != null) {
        
            for (int col = leftColumn; col <= rightColumn && head != null; col++) {
                matrix[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;

        
            for (int row = topRow; row <= bottomRow && head != null; row++) {
                matrix[row][rightColumn] = head.val;
                head = head.next;
            }
            rightColumn--;

 
            for (int col = rightColumn; col >= leftColumn && head != null; col--) {
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;

       
            for (int row = bottomRow; row >= topRow && head != null; row--) {
                matrix[row][leftColumn] = head.val;
                head = head.next;
            }
            leftColumn++;
        }

        return matrix;
    }
}

//kartikdevsharmaa