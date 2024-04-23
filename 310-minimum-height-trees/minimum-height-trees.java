// class Solution {
//     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//         if(n==1) return Collections.singletonList(0);

//         List<Set<Integer>> adj=new ArrayList<>();
//         for(int i=0;i<n;i++) adj.add(new HashSet<>());

//         for(int[] temp:edges){
//             adj.get(temp[0]).add(temp[1]);
//             adj.get(temp[1]).add(temp[0]);
//         }

//         List<Integer> leaves=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             if(adj.get(i).size()==1) leaves.add(i);
//         }

//         while(n>2){
//             n-=leaves.size();
//             List<Integer> newleaves=new ArrayList<>();
//             for(int i:leaves){
//                 int j=adj.get(i).iterator().next();
//                 adj.get(j).remove(i);
//                 if(adj.get(j).size()==1) newleaves.add(j);
//             }
//             leaves=newleaves;
//         }
//         return leaves;
//     }
// }

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] counts = new int[n];
        int[] links = new int[n];
        for (int[] edge : edges) {
            links[edge[0]] ^= edge[1];
            counts[edge[0]]++;
            links[edge[1]] ^= edge[0];
            counts[edge[1]]++;
        }
        Queue<Integer> Qu = new LinkedList<>();
        int[] dists = new int[n];
        for (int i = 0; i < n; i++) {
            if (counts[i] == 1)
                Qu.add(i);
        }
        int stp = 1;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int j = 0; j < size; j++) {
                int tmp = Qu.poll();
                links[links[tmp]] ^= tmp;
                counts[links[tmp]]--;
                if (counts[links[tmp]] == 1) {
                    dists[links[tmp]] = Math.max(stp, dists[links[tmp]]);
                    Qu.add(links[tmp]);
                }
            }
            stp++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dists[i], max);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dists[i] == max)
                res.add(i);
        }
        return res;
    }
}