// public class Solution {
//     public List<List<Integer>> generate(int numRows)
//     {   
// 	    List<List<Integer>> allrows = new ArrayList<>();
// 	    ArrayList<Integer> row = new ArrayList<>();
// 	    for(int i=0;i<numRows;i++)
// 	    {
// 		    row.add(0, 1);
// 		    for(int j=1;j<row.size()-1;j++)
// 			    row.set(j, row.get(j)+row.get(j+1));
// 		    allrows.add(new ArrayList<Integer>(row));
// 	    }
// 	    return allrows;
//     }
// }

class Solution {
    public List<Integer> gen(int row){
        List<Integer> list = new ArrayList<>();
        int ans = 1;
        list.add(ans);
        for(int col = 1; col < row; col++){
            ans = ans * (row - col);
            ans = ans / col;
            list.add(ans);
        }
        return list;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i<=numRows;i++){
            ans.add(gen(i));
        }
        return ans;
    }
}