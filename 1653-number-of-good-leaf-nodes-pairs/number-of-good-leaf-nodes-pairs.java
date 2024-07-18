class Solution {
  public int countPairs(TreeNode root, int distance) {
        int[] result= new int[1];
        dfs(root,distance,result);
        return result[0];
    }
    private int[] dfs(TreeNode node,int distance, int[] result){
        if(node==null){
            return new int[distance+1];
        }
        if(node.left==null&&node.right==null){
            int[] leafDistance = new int[distance+1];
            leafDistance[1]=1;
            return leafDistance;
        }

        int[] left=dfs(node.left,distance,result);
        int[] right= dfs(node.right,distance,result);

        //calculate result
        for(int i=1;i<=distance;i++){
            for(int j=1;j<=distance-i;j++){
                result[0] += left[i]*right[j];
            }
        }

        int[] leafDistance = new int[distance+1];
        for(int i=1;i<distance;i++){
            leafDistance[i+1]= left[i]+ right[i];
        }
        return leafDistance;
    }
}


