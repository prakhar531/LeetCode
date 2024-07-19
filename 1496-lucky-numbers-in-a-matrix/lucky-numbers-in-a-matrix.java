// class Solution {
//     public List<Integer> luckyNumbers(int[][] matrix) {
//         int N = matrix.length, M = matrix[0].length;

//         List<Integer> rowMin = new ArrayList<>();
//         for (int i = 0; i < N; i++) {
//             int rMin = Integer.MAX_VALUE;
//             for (int j = 0; j < M; j++) {
//                 rMin = Math.min(rMin, matrix[i][j]);
//             }
//             rowMin.add(rMin);
//         }

//         List<Integer> colMax = new ArrayList<>();
//         for (int i = 0; i < M; i++) {
//             int cMax = Integer.MIN_VALUE;
//             for (int j = 0; j < N; j++) {
//                 cMax = Math.max(cMax, matrix[j][i]);
//             }
//             colMax.add(cMax);
//         }

//         List<Integer> luckyNumbers = new ArrayList<>();
//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < M; j++) {
//                 if (matrix[i][j] == rowMin.get(i) && matrix[i][j] == colMax.get(j)) {
//                     luckyNumbers.add(matrix[i][j]);
//                 }
//             }
//         }

//         return luckyNumbers;
//     }
// }

// class Solution {
//     public List<Integer> luckyNumbers(int[][] matrix) {
//         int N = matrix.length, M = matrix[0].length;

//         int rMinMax = Integer.MIN_VALUE;
//         for (int i = 0; i < N; i++) {
//             int rMin = Integer.MAX_VALUE;
//             for (int j = 0; j < M; j++) {
//                 rMin = Math.min(rMin, matrix[i][j]);
//             }
//             rMinMax = Math.max(rMinMax, rMin);
//         }

//         int cMaxMin = Integer.MAX_VALUE;
//         for (int i = 0; i < M; i++) {
//             int cMax = Integer.MIN_VALUE;
//             for (int j = 0; j < N; j++) {
//                 cMax = Math.max(cMax, matrix[j][i]);
//             }
//             cMaxMin = Math.min(cMaxMin, cMax);
//         }

//         if (rMinMax == cMaxMin) {
//             return new ArrayList<>(Arrays.asList(rMinMax));
//         }

//         return new ArrayList<>();
//     }
// }

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> lsRes = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++)
        {
            int col = findMin(matrix, i);

            int maxCol = matrix[i][col];
            if(maxInCol(matrix, maxCol, col))
                lsRes.add(maxCol);
            // for(int r = 0; r < matrix.length; r++)
            // {
            //     if(matrix[r][col] > maxCol)
            //         maxCol = matrix[r][col];
            // }

            // if(minRow == maxCol)
            //     lsRes.add(matrix[i][col]);
        }

        return lsRes;
    }
    private int findMin(int[][] matrix, int row){
		int val= matrix[row][0], col=0;
		for(int i=1;i<matrix[row].length;i++){
			if(matrix[row][i]<val){
				val=matrix[row][i];
				col=i;
			}
		}
		return col;
	}
    private boolean maxInCol(int[][] matrix, int val, int col){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]>val)
                return false;
        }
        return true;
    }
}