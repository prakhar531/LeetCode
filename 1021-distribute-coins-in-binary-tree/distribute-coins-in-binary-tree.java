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
    public int move=0;
    public int solve(TreeNode root) {
        if(root==null) return 0;
        int lval=solve(root.left);
        int rval=solve(root.right);

        move+=Math.abs(lval)+Math.abs(rval);
        return (root.val-1)+lval+rval;
    }
    public int distributeCoins(TreeNode root) {
        solve(root);
        return move;
    }
}