// class Solution {
//         public int[] sumOfDistancesInTree(int n, int[][] edges) {
//         // build graph and declare results
//         final ArrayList<Integer>[] graph = new ArrayList[n];
//         final int[] count = new int[n];
//         Arrays.fill(count, 1);
//         final int[] answer = new int[n];
//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }
//         for (int[] edge : edges) {
//             graph[edge[0]].add(edge[1]);
//             graph[edge[1]].add(edge[0]);
//         }

//         postOrder(0, -1, graph, count, answer);
//         // after postOrder, only answer[root] is correct, so do preOrder to update answer
//         preOrder(0, -1, graph, count, answer, n);

//         return answer;
//     }

//     // set count et subTreeSum, here use answer[]
//     private void postOrder(int node, int parent, ArrayList<Integer>[] graph, int[] count, int[] answer) {
//         for (int child : graph[node]) {
//             if (child != parent) {
//                 postOrder(child, node, graph, count, answer);
//                 count[node] += count[child];
//                 answer[node] += answer[child] + count[child];
//             }
//         }
//     }

//     private void preOrder(int node, int parent, ArrayList<Integer>[] graph, int[] count, int[] answer, int n) {
//         for (int child : graph[node]) {
//             if (child != parent) {
//                 answer[child] = answer[node] + (n - count[child]) - count[child];
//                 preOrder(child, node, graph, count, answer, n);
//             }
//         }
//     }
// }

class Solution {
    int[][] graph;
    int[] count;
    int[] res;
    int N;
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        this.res = new int[N];
        this.graph = new int[N][];
        this.count = new int[N];
        
        for (int[] e : edges) {
            ++count[e[0]];
            ++count[e[1]];
        }
        for (int i = 0; i < N; i++) {
            graph[i] = new int[count[i]];
        }
        for (int[] e : edges) {
            graph[e[0]][--count[e[0]]] = e[1];
            graph[e[1]][--count[e[1]]] = e[0];
        }
        dfs1(0, -1);
        dfs2(0, -1);
        return res;
    }
    public void dfs1(int cur, int parent) {
        count[cur] = 1;
        for (int child : graph[cur]) {
            if (child != parent) {
                dfs1(child, cur);
                count[cur] += count[child];
                res[cur] += res[child] + count[child];
            }
        }
    }
    public void dfs2(int cur, int parent) {
        for (int child : graph[cur]) {
            if (child != parent) {
                res[child] = res[cur] + N - 2 * count[child];
                dfs2(child, cur);
            }
        }
    }
}