// class Solution {
//     public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
//         int dir[][]=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
//         int ans[][]=new int[rows*cols][2];
//         int step=1;
//         int direction=0;
//         int idx=0;
//         while(idx<rows*cols){
//             for(int i=0;i<2;i++){
//                 for(int j=0;j<step;j++){
//                     if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
//                         ans[idx][0]=rStart;
//                         ans[idx][1]=cStart;
//                         idx++;
//                     }
//                     rStart+=dir[direction][0];
//                     cStart+=dir[direction][1];
//                 }
//                 direction=(direction+1)%4;
//             }
//             step++;
//         }
//         return ans;
//     }
// }
// class Solution {

//     public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
//         // Store all possible directions in an array.
//         int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
//         int[][] traversed = new int[rows * cols][2];
//         int idx = 0;

//         // Initial step size is 1, value of d represents the current direction.
//         for (int step = 1, direction = 0; idx < rows * cols;) {
//             // direction = 0 -> East, direction = 1 -> South
//             // direction = 2 -> West, direction = 3 -> North
//             for (int i = 0; i < 2; ++i) {
//                 for (int j = 0; j < step; ++j) {
//                     // Validate the current position
//                     if (
//                         rStart >= 0 &&
//                         rStart < rows &&
//                         cStart >= 0 &&
//                         cStart < cols
//                     ) {
//                         traversed[idx][0] = rStart;
//                         traversed[idx][1] = cStart;
//                         ++idx;
//                     }
//                     // Make changes to the current position.
//                     rStart += dir[direction][0];
//                     cStart += dir[direction][1];
//                 }

//                 direction = (direction + 1) % 4;
//             }
//             ++step;
//         }
//         return traversed;
//     }
// }

class Solution {
int minX, minY, maxX, maxY, index;

    int[][] result;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int n = cols * rows;
        result = new int[n][];

        minX = cStart;
        maxX = cStart + 1;
        minY = rStart;
        maxY = rStart;
        index = 0;
        result[index++] = new int[]{rStart, cStart};

        while (true) {
            if (minY >= 0){
                right(Math.max(0, minX + 1), Math.min(cols - 1, maxX));
            } 
            maxY++;
            if (index >= n) break;

            if (maxX < cols) down(Math.max(0, minY + 1), Math.min(rows - 1, maxY));
            minX--;
            if (index >= n) break;

            if (maxY < rows) left(Math.min(cols - 1, maxX - 1), Math.max(0, minX));
            minY--;
            if (index >= n) break;

            if (minX >= 0) up(Math.min(rows - 1, maxY - 1), Math.max(0, minY));
            maxX++;
            if (index >= n) break;
        }
        return result;
    }

    public void right(int start, int end) {
        for (int i = start; i <= end; i++) 
            result[index++] = new int[]{minY, i};
    }

    public void left(int start, int end) {
        for (int i = start; i >= end; i--) 
           result[index++] = new int[]{maxY, i};
    }

    public void down(int start, int end) {
        for (int i = start; i <= end; i++) 
            result[index++] = new int[]{i, maxX};
    }

    public void up(int start, int end) {
        for (int i = start; i >= end; i--) 
           result[index++] = new int[]{i, minX};
    }
}