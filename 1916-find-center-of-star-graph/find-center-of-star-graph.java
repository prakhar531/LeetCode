class Solution {
    public int findCenter(int[][] e) {
        // HashSet<Integer> set=new HashSet<>();
        // int ans=0;
        // set.add(edges[0][0]);
        // set.add(edges[0][1]);
        // for(int row[]:edges){
        //     for(int num:row){
        //         if(set.contains(num)) ans=num;  
        //     }
        // }
        // return ans;
    return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }
}