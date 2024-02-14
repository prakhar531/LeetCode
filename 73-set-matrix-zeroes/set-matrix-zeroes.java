// class Solution {
//     public void setZeroes(int[][] matrix) {
        
//         // ArrayList<Integer> row=new ArrayList<>();
//         // ArrayList<Integer> col=new ArrayList<>();

//         // for(int i=0;i<matrix.length;i++){
//         //     for(int j=0;j<matrix[0].length;j++){
//         //         if(matrix[i][j]==0){
//         //             if(!row.contains(i)){
//         //                 row.add(i);
//         //             }
//         //             if(!col.contains(j)){
//         //                 col.add(j);
//         //             }
//         //         }
//         //     }
//         // }
//         // int itr=0;
//         // if(row.size()==0){
//         //     return;
//         // }
//         // for(int i=0;i<matrix.length;i++){
//         //     if(itr<row.size() && row.get(itr)==i ){
//         //         for(int j=0;j<matrix[0].length;j++)
//         //         {
//         //             matrix[i][j]=0;
//         //         }
//         //         itr++;
//         //     }
//         // }
//         // itr=0;
//         // Collections.sort(col);
//         // for(int i=0;i<matrix[0].length;i++){
//         //     if( itr<col.size()  && col.get(itr)==i){
//         //         for(int j=0;j<matrix.length;j++){
//         //             matrix[j][i]=0;
//         //         }
//         //         itr++;
//         //     }
//         // }

//         int row[]=new int[matrix.length];
//         int col[]=new int[matrix[0].length];

//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[0].length;j++){
//                 if(matrix[i][j]==0){
//                     if(row[i]!=1) row[i]=1;
//                     if(col[j]!=1) col[j]=1;
//                 }
//             }
//         }

//         for(int i=0;i<matrix.length;i++){
//             if(row[i]==0) continue;
//             for(int j=0;j<matrix[0].length;j++){
//                 matrix[i][j]=0;
//             }
//         }

//         for(int i=0;i<matrix[0].length;i++){
//             if(col[i]==0) continue;
//             for(int j=0;j<matrix.length;j++){
//                 matrix[j][i]=0;
//             }
//         }
//     }
// }

class Solution {
    public void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] columns = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] != 1) continue;
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j = 0; j < columns.length; j++) {
            if (columns[j] != 1) continue;
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        } 
    }
}