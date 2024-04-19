class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&grid[i][j]=='1'){
                    count++;
                    dfsutil(grid,vis,i,j);
                }
            }
        }
        return count;
    }
    public void dfsutil(char[][] grid,boolean vis[][],int i,int j){
        if(vis[i][j]) return;
        vis[i][j]=true;
        if (i > 0 && grid[i-1][j] == '1')
		    dfsutil(grid,vis, i-1, j);
	    if (i < grid.length - 1 && grid[i+1][j] == '1')
		    dfsutil(grid,vis, i+1, j);
	    if (j > 0 && grid[i][j-1] == '1')
		    dfsutil(grid,vis, i, j-1);
	    if (j < grid[i].length - 1 && grid[i][j+1] == '1' )
		    dfsutil(grid,vis, i, j+1);
    }
}