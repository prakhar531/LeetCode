class Solution {
    public int max=0;
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0) solve(grid,i,j,0);
            }
        }
        return max;
    }
    public void solve(int[][] grid,int i,int j,int sum){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0){
            return;
        }
        int curr=grid[i][j];
        sum+=curr;
        max=Math.max(sum,max);
        grid[i][j]=0;
        solve(grid,i+1,j,sum);
        solve(grid,i-1,j,sum);
        solve(grid,i,j+1,sum);
        solve(grid,i,j-1,sum);
        grid[i][j]=curr;
    }
}