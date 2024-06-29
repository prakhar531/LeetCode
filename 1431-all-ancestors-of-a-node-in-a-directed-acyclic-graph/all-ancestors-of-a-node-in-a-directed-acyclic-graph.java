class Solution {
    class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public void dfs(ArrayList<Edge> graph[],int curr,boolean[] vis,ArrayList<Integer> temp){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!temp.contains(e.dest)) temp.add(e.dest);
            if(!vis[e.dest]) dfs(graph,e.dest,vis,temp);
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Edge> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[1]].add(new Edge(edge[1],edge[0]));
        }
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            Arrays.fill(vis,false);
            ArrayList<Integer> temp=new ArrayList<>();
            dfs(graph,i,vis,temp);
            Collections.sort(temp);
            ans.add(temp);
        }
        return ans;
    }
}