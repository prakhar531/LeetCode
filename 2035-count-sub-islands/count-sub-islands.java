// class Solution {

//     // Directions in which we can traverse inside the grids.
//     private final int[][] directions = {
//         { 0, 1 },
//         { 1, 0 },
//         { 0, -1 },
//         { -1, 0 },
//     };

//     // Helper method to check if the cell at the position (x, y) in the 'grid'
//     // is a land cell.
//     private boolean isCellLand(int x, int y, int[][] grid) {
//         return grid[x][y] == 1;
//     }

//     // Traverse all cells of island starting at position (x, y) in 'grid2',
//     // and check if this island is a sub-island in 'grid1'.
//     private boolean isSubIsland(
//         int x,
//         int y,
//         int[][] grid1,
//         int[][] grid2,
//         boolean[][] visited
//     ) {
//         int totalRows = grid2.length;
//         int totalCols = grid2[0].length;
//         // Traverse on all cells using the depth-first search method.
//         boolean isSubIsland = true;

//         // If the current cell is not a land cell in 'grid1', then the current island can't be a sub-island.
//         if (!isCellLand(x, y, grid1)) {
//             isSubIsland = false;
//         }

//         // Traverse on all adjacent cells.
//         for (int[] direction : directions) {
//             int nextX = x + direction[0];
//             int nextY = y + direction[1];
//             // If the next cell is inside 'grid2', is not visited, and is a land cell,
//             // then we traverse to the next cell.
//             if (
//                 nextX >= 0 &&
//                 nextY >= 0 &&
//                 nextX < totalRows &&
//                 nextY < totalCols &&
//                 !visited[nextX][nextY] &&
//                 isCellLand(nextX, nextY, grid2)
//             ) {
//                 // Mark the next cell as visited.
//                 visited[nextX][nextY] = true;
//                 boolean nextCellIsPartOfSubIsland = isSubIsland(
//                     nextX,
//                     nextY,
//                     grid1,
//                     grid2,
//                     visited
//                 );
//                 isSubIsland = isSubIsland && nextCellIsPartOfSubIsland;
//             }
//         }
//         return isSubIsland;
//     }

//     public int countSubIslands(int[][] grid1, int[][] grid2) {
//         int totalRows = grid2.length;
//         int totalCols = grid2[0].length;

//         boolean[][] visited = new boolean[totalRows][totalCols];
//         int subIslandCounts = 0;

//         // Iterate over each cell in 'grid2'.
//         for (int x = 0; x < totalRows; ++x) {
//             for (int y = 0; y < totalCols; ++y) {
//                 // If the cell at position (x, y) in 'grid2' is not visited,
//                 // is a land cell in 'grid2', and the island starting from this cell is a sub-island in 'grid1',
//                 // then increment the count of sub-islands.
//                 if (!visited[x][y] && isCellLand(x, y, grid2)) {
//                     visited[x][y] = true;
//                     if (isSubIsland(x, y, grid1, grid2, visited)) {
//                         subIslandCounts += 1;
//                     }
//                 }
//             }
//         }
//         // Return total count of sub-islands.
//         return subIslandCounts;
//     }
// }
class Solution {
    int n, m;
    int[][] isValid;
    int[] dx = new int[] {-1, 0 , 0 ,1};
    int[] dy = new int[] {0, -1, 1, 0};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;
        isValid = new int[n][m];
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (isValid[i][j] == 0 && grid2[i][j] == 1) {
                    if (isSubIslands(i, j, grid1, grid2)) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    private boolean isSubIslands(int r, int c, int[][] grid1, int[][] grid2) {
        if (grid1[r][c] != 1) {
            isValid[r][c] = -1;
            return false;
        }
        isValid[r][c] = 1;
        for (int k = 0 ; k < 4; k++) {
            int nr = r + dx[k];
            int nc = c + dy[k];
            if (nr <  0 || nr >= n || nc < 0 || nc >= m) continue;
            if (isValid[nr][nc] == -1) {
                isValid[r][c] = -1;
                return false;
            }
            if (isValid[nr][nc] == 1) continue;
            if (grid2[nr][nc] == 1 && !isSubIslands(nr, nc, grid1, grid2)) {
                isValid[r][c] = -1;
                return false;
            }
        }
        return true;
    }
}