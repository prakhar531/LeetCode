// class Solution {
//     public int max=0;
//     public int getMaximumGold(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]!=0) solve(grid,i,j,0);
//             }
//         }
//         return max;
//     }
//     public void solve(int[][] grid,int i,int j,int sum){
//         if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0){
//             return;
//         }
//         int curr=grid[i][j];
//         sum+=curr;
//         max=Math.max(sum,max);
//         grid[i][j]=0;
//         solve(grid,i+1,j,sum);
//         solve(grid,i-1,j,sum);
//         solve(grid,i,j+1,sum);
//         solve(grid,i,j-1,sum);
//         grid[i][j]=curr;
//     }
// }

class Solution {
    public int max = 0;
    public void ways(int[][] grid,int r, int c, int gold){
        if(gold > max){
            max = gold;
        }
        if(grid[r][c] == 0){
            return;
        }
        int a = grid[r][c];
        grid[r][c] = 0;
        if(r - 1 >= 0){
            ways(grid,r - 1, c, gold + a);
        }
        if(r + 1 <= grid.length - 1){
            ways(grid,r + 1,c,gold + a);
        }
        if(c + 1 <= grid[0].length - 1){
            ways(grid,r, c + 1, gold + a);
        }
        if(c - 1 >= 0){
            ways(grid,r, c - 1, gold + a);
        }
        grid[r][c] = a;
        return ;

    }

    public int gridWithNoZeros(int[][] grid){
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    return -1;
                }
                else
                    count += grid[i][j];
            }
        }
        return count;
    }  



    public int getMaximumGold(int[][] grid) {

        int count = gridWithNoZeros(grid);
        if(count != -1) return count;

        
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0 ; j < grid[0].length ; j++){
                ways(grid,i,j,0);
            }
        }
        return max;
    }
}