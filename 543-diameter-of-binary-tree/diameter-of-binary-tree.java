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
    class Info {
        int dia;
        int hig;
        public Info(int dia,int hig){
            this.dia=dia;
            this.hig=hig;
        }
    }

    public Info getDia(TreeNode root){
        if(root==null) return new Info(0,0);

        Info linfo=getDia(root.left);
        Info rinfo=getDia(root.right);

        int dia=Math.max(linfo.hig+rinfo.hig+1,Math.max(linfo.dia,rinfo.dia));
        int hight=Math.max(linfo.hig,rinfo.hig)+1;

        return new Info(dia,hight);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        Info ans=getDia(root);
        return ans.dia-1;
    }
}