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
    public void solve(TreeNode root, int val, int depth,int curr){
        if(root==null) return;
        if(curr==depth-1){
            TreeNode lTemp=root.left;
            TreeNode rTemp=root.right;

            root.left=new TreeNode(val);
            root.right=new TreeNode(val);

            root.left.left=lTemp;
            root.right.right=rTemp;

            return;
        }
        solve(root.left,val,depth,curr+1);
        solve(root.right,val,depth,curr+1);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        solve(root,val,depth,1);
        return root;
    }
}