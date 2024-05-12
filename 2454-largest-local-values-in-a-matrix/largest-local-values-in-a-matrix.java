class Solution {
    public int calculate(int[][] grid,int i,int j){
        int max=Integer.MIN_VALUE;
        for(int x=i-1;x<=i+1;x++){
            for(int y=j-1;y<=j+1;y++){
                max=Math.max(max,grid[x][y]);
            }
        }
        return max;
    }
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int ans[][]=new int[n-2][n-2];

        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                ans[i][j]=calculate(grid,i+1,j+1);
            }
        }
        return ans;
    }
}