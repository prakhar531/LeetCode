// class Solution {
//     public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//         Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
//         for (int i = 0; i < edges.length; i++) {
//             int u = edges[i][0], v = edges[i][1];
//             double pathProb = succProb[i];
//             graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
//             graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
//         }

//         double[] maxProb = new double[n];
//         maxProb[start] = 1d;

//         PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.getKey(), b.getKey()));
//         pq.add(new Pair<>(1.0, start));
//         while (!pq.isEmpty()) {
//             Pair<Double, Integer> cur = pq.poll();
//             double curProb = cur.getKey();
//             int curNode = cur.getValue();
//             if (curNode == end) {
//                 return curProb;
//             }
//             for (Pair<Integer, Double> nxt : graph.getOrDefault(curNode, new ArrayList<>())) {
//                 int nxtNode = nxt.getKey();
//                 double pathProb = nxt.getValue();
//                 if (curProb * pathProb > maxProb[nxtNode]) {
//                     maxProb[nxtNode] = curProb * pathProb;
//                     pq.add(new Pair<>(maxProb[nxtNode], nxtNode));
//                 }
//             }
//         }

//         return 0d;
//     }
// }

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] probs = new double[n];
        probs[start_node] = 1;
        for(int i = 0; i < n - 1; i++) {
            boolean change = false;
            for(int j = 0; j < edges.length; j++) {
                int src = edges[j][0];
                int dest = edges[j][1];
                double prob = succProb[j];

                if(probs[src] * prob > probs[dest]) {
                    probs[dest] = probs[src] * prob;
                    change = true;
                }
                if(probs[dest] * prob > probs[src]) {
                    probs[src] = probs[dest] * prob;
                    change = true;
                }
            }
            if(change == false) break;
        }
        return probs[end_node];
    }
}