// class Solution {
//   public int findPaths(int m, int n, int N, int i, int j) {
//     if (i == m || j == n || i < 0 || j < 0) return 1;
//     if (N == 0) return 0;
//     return findPaths(m, n, N - 1, i - 1, j)
//         + findPaths(m, n, N - 1, i + 1, j)
//         + findPaths(m, n, N - 1, i, j - 1)
//         + findPaths(m, n, N - 1, i, j + 1);
//   }
// }

// class Solution {
//   int M = 1000000007;

//   public int findPaths(int m, int n, int N, int i, int j) {
//     int[][][] memo = new int[m][n][N + 1];
//     for (int[][] l : memo) for (int[] sl : l) Arrays.fill(sl, -1);
//     return findPaths(m, n, N, i, j, memo);
//   }

//   public int findPaths(int m, int n, int N, int i, int j, int[][][] memo) {
//     if (i == m || j == n || i < 0 || j < 0) return 1;
//     if (N == 0) return 0;
//     if (memo[i][j][N] >= 0) return memo[i][j][N];
//     memo[i][j][N] = (
//         (findPaths(m, n, N - 1, i - 1, j, memo) + findPaths(m, n, N - 1, i + 1, j, memo)) % M +
//         (findPaths(m, n, N - 1, i, j - 1, memo) + findPaths(m, n, N - 1, i, j + 1, memo)) % M
//     ) % M;
//     return memo[i][j][N];
//   }
// }

class Solution {
  public int findPaths(int m, int n, int N, int x, int y) {
    int M = 1000000000 + 7;
    int dp[][] = new int[m][n];
    dp[x][y] = 1;
    int count = 0;
    for (int moves = 1; moves <= N; moves++) {
      int[][] temp = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == m - 1) count = (count + dp[i][j]) % M;
          if (j == n - 1) count = (count + dp[i][j]) % M;
          if (i == 0) count = (count + dp[i][j]) % M;
          if (j == 0) count = (count + dp[i][j]) % M;
          temp[i][j] = (
              ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M +
              ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M
          ) % M;
        }
      }
      dp = temp;
    }
    return count;
  }
}