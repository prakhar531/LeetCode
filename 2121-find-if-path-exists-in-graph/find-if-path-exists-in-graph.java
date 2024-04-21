// class Solution {
//     public class Edge{
//         int src;
//         int dest;
//         public Edge(int src,int dest){
//             this.src=src;
//             this.dest=dest;
//         }
//     }
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         boolean vis[]=new boolean[n];
//         ArrayList<Edge> graph[]=new ArrayList[n];
//         for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

//         for(int i=0;i<edges.length;i++){
//             graph[edges[i][0]].add(new Edge(edges[i][0],edges[i][1]));
//             graph[edges[i][1]].add(new Edge(edges[i][1],edges[i][0]));
//         }
//         return dfs(graph,vis,source,destination);
//     }
//     public boolean dfs(ArrayList<Edge> graph[],boolean vis[],int src,int dest){
//         if(src==dest) return true;
//         vis[src]=true;
//         for(int i=0;i<graph[src].size();i++){
//             Edge e=graph[src].get(i);
//             if((!vis[e.dest]) && dfs(graph,vis,e.dest,dest)) return true;
//         }
//         return false;
//     }
// }
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0) return true;
        boolean[] visited = new boolean[n];
        boolean flag = true;
        visited[source] = true;
    while(flag){
        flag = false;
        for(int[] edge : edges){
            if(visited[edge[0]] != visited[edge[1]]){
                visited[edge[0]] = true;
                visited[edge[1]] = true;
                flag = true;
            }
            if(visited[destination]) return true;
        }
    }
    return false;
    }
}
/*
TC: O(V+E)
SC: O(V+E)
*/
// class Solution {
//     boolean found = false;
//     public boolean validPath(int n, int[][] edges, int start, int end) {
//         if(start == end) return  true;
        
//         Map<Integer,List<Integer>> graph = new HashMap();
//         boolean[] visited = new boolean[n];
        
//         for(int i = 0 ; i < n ; i++) graph.put(i, new ArrayList());
//         for(int[] edge : edges){
//            graph.get(edge[0]).add(edge[1]);
//            graph.get(edge[1]).add(edge[0]);
//         }
//         dfs(graph,visited,start,end);
//         return found;
//     }
    
//     private void dfs(Map<Integer,List<Integer>> graph,boolean[] visited, int start, int end){
//         if(visited[start] || found) return;
//         visited[start] = true;
//         for(int nei : graph.get(start)){
//             if(nei == end){
//                 found = true;
//                 break;
//             }
//             if(!visited[nei])
//                 dfs(graph, visited, nei, end);
//         }
//     }
// }