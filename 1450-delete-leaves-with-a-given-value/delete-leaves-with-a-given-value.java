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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) return null;
        TreeNode lvalue=removeLeafNodes(root.left,target);
        TreeNode rvalue=removeLeafNodes(root.right,target);
        root.left=lvalue;
        root.right=rvalue;
        if(lvalue==null&&rvalue==null&&root.val==target){
            return null;
        }
        return root;
        
    }
}