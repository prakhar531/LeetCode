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
    public boolean evaluateTree(TreeNode root) {
        if(root.left==null && root.right==null){
            return root.val==1?true:false;
        }
        boolean ltree=evaluateTree(root.left);
        boolean rtree=evaluateTree(root.right);
        if(root.val==2) return ltree||rtree;
        return ltree&&rtree;
    }
}