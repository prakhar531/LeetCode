/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode> ans=new ArrayList<>();
    public TreeNode solve(TreeNode root, HashSet<Integer> set){
        if(root==null) return null;
        
        root.left=solve(root.left,set);
        root.right=solve(root.right,set);

        if(set.contains(root.val)){
            if(root.left!=null) ans.add(root.left);
            if(root.right!=null) ans.add(root.right);
            return null;
        }

        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set=new HashSet<>();
        for(int it:to_delete){
            set.add(it);
        }
        solve(root,set);
        if(!set.contains(root.val)) ans.add(root);
        return ans;
    }
}