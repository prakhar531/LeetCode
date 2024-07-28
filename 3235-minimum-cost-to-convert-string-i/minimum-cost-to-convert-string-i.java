// class Solution {

//     public long minimumCost(
//         String source,
//         String target,
//         char[] original,
//         char[] changed,
//         int[] cost
//     ) {
//         // Initialize result to store the total minimum cost
//         long totalCost = 0;

//         // Initialize a 2D array to store the minimum conversion cost
//         // between any two characters
//         long[][] minCost = new long[26][26];
//         for (long[] row : minCost) {
//             Arrays.fill(row, Integer.MAX_VALUE);
//         }

//         // Fill the initial conversion costs from the given original,
//         // changed, and cost arrays
//         for (int i = 0; i < original.length; ++i) {
//             int startChar = original[i] - 'a';
//             int endChar = changed[i] - 'a';
//             minCost[startChar][endChar] = Math.min(
//                 minCost[startChar][endChar],
//                 (long) cost[i]
//             );
//         }

//         // Use Floyd-Warshall algorithm to find the shortest path between any
//         // two characters
//         for (int k = 0; k < 26; ++k) {
//             for (int i = 0; i < 26; ++i) {
//                 for (int j = 0; j < 26; ++j) {
//                     minCost[i][j] = Math.min(
//                         minCost[i][j],
//                         minCost[i][k] + minCost[k][j]
//                     );
//                 }
//             }
//         }

//         // Calculate the total minimum cost to transform the source string to
//         // the target string
//         for (int i = 0; i < source.length(); ++i) {
//             if (source.charAt(i) == target.charAt(i)) {
//                 continue;
//             }
//             int sourceChar = source.charAt(i) - 'a';
//             int targetChar = target.charAt(i) - 'a';

//             // If the transformation is not possible, return -1
//             if (minCost[sourceChar][targetChar] >= Integer.MAX_VALUE) {
//                 return -1;
//             }
//             totalCost += minCost[sourceChar][targetChar];
//         }

//         return totalCost;
//     }
// }

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            dis[original[i] - 'a'][changed[i] - 'a'] = Math.min(dis[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++)
                if (dis[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (dis[k][j] < Integer.MAX_VALUE) {
                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                        }
                    }
                }
        }
        long ans = 0L;
        for (int i = 0; i < source.length(); i++) {
            int c1 = source.charAt(i) - 'a';
            int c2 = target.charAt(i) - 'a';
            if (dis[c1][c2] == Integer.MAX_VALUE) {
                return -1L;
            } else {
                ans += (long)dis[c1][c2];
            }
        }
        return ans;
    }
}