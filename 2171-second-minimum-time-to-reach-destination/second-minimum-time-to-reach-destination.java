class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        /**
            1. traffic light is global
                - if a departs before b, a will always arrive first
                    - if a delays bc of red light, b will be delayed as well 
                - carry the time forward
                - round=curTime/change
                    - if round is even, then it is green
                        - nextTime=curTime+time
                    - if round is odd, then it is red
                        - wait
                        - nextTime=curTime+2*time, (round+1)*change+time
            2. the question is asking for second minimum time
                - if A->...->B1->...->C, a second minumum time would be
                    - A->...->B1->...->B2->...-->C
                    - a node can be visited twice
            3. use an timeArr to keep track of the 2nd minimum time for every node
                - bfs into next only timeArr[i]<nextTime
         */

        List<Integer>[] graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++) graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        Deque<int[]> deque=new LinkedList<>();
        int[] visitedNum=new int[n+1];
        int[] timeArr=new int[n+1];
        Arrays.fill(timeArr,-1);
        deque.offerLast(new int[]{1,0});
        timeArr[0]=0;

        while(deque.size()>0){
            int curSize=deque.size();
            for(int i=0;i<curSize;i++){
                int[] cur=deque.pollFirst();
                //if(cur[0]==n && visitedNum[cur[0]]==2) return cur[1];
                
                int nextTime=0;
                int curLight=cur[1]/change;
                if(curLight%2==0){
                    nextTime=cur[1]+time;
                }
                //nextTime=(curLight+1)*change+time;
                else nextTime=(curLight+1)*change+time;

                for(int nextNode:graph[cur[0]]){
                    if(visitedNum[nextNode]<2 && timeArr[nextNode]<nextTime){
                        deque.offerLast(new int[]{nextNode,nextTime});
                        visitedNum[nextNode]++;
                        timeArr[nextNode]=nextTime;
                        if(nextNode==n && visitedNum[nextNode]==2) return nextTime; 
                    }    
                }
                
            }
        }
        return -1;
    }
}
// class Solution {
//     public int secondMinimum(int n, int[][] edges, int time, int change) {
//         Map<Integer, List<Integer>> adj = new HashMap<>();
//         for (int[] edge : edges) {
//             int a = edge[0], b = edge[1];
//             adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
//             adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
//         }
//         int[] dist1 = new int[n + 1], dist2 = new int[n + 1];
//         for (int i = 1; i <= n; i++) {
//             dist1[i] = dist2[i] = -1;
//         }
//         Queue<int[]> queue = new LinkedList<>();
//         // Start with node 1, with its minimum distance.
//         queue.offer(new int[] { 1, 1 });
//         dist1[1] = 0;

//         while (!queue.isEmpty()) {
//             int[] temp = queue.poll();
//             int node = temp[0];
//             int freq = temp[1];

//             int timeTaken = freq == 1 ? dist1[node] : dist2[node];
//             // If the time_taken falls under the red bracket, wait till the path turns
//             // green.
//             if ((timeTaken / change) % 2 == 1) {
//                 timeTaken = change * (timeTaken / change + 1) + time;
//             } else {
//                 timeTaken = timeTaken + time;
//             }

//             if (!adj.containsKey(node))
//                 continue;
//             for (int neighbor : adj.get(node)) {
//                 if (dist1[neighbor] == -1) {
//                     dist1[neighbor] = timeTaken;
//                     queue.offer(new int[] { neighbor, 1 });
//                 } else if (dist2[neighbor] == -1 && dist1[neighbor] != timeTaken) {
//                     if (neighbor == n)
//                         return timeTaken;
//                     dist2[neighbor] = timeTaken;
//                     queue.offer(new int[] { neighbor, 2 });
//                 }
//             }

//         }
//         return 0;
//     }
// }