class Solution {
    public void filpRow(int i,int[][] grid,int n){
        for(int j=0;j<n;j++){
            grid[i][j]=grid[i][j]==1?0:1;
        }
    }
    public void flipCol(int j,int[][] grid,int m){
        for(int i=0;i<m;i++){
            grid[i][j]=grid[i][j]==1?0:1;
        }
    }
    public int count(int j,int[][] grid,int m){
        int ans=0;
        for(int i=0;i<m;i++){
            ans+=grid[i][j];
        }
        return ans;
    }
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]!=1) filpRow(i,grid,n);
        }
        for(int j=1;j<n;j++){
            int val=count(j,grid,m);
            if(val<m-val) flipCol(j,grid,m);
        }
        int sum=0;
        for(int i=0;i<m;i++){
            int curr=0;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) curr+=Math.pow(2,n-1-j);
            }
            sum+=curr;
        }
        return sum;
    }
}