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

    class Info{
        int dia;
        int height;
        Info(int dia,int height){
            this.dia=dia;
            this.height=height;
        }
    }

    public Info getDia(TreeNode root){
        if(root==null){
            return (new Info(0,0));
        }
        Info l=getDia(root.left);
        Info r=getDia(root.right);

        int dia=Math.max(l.height+r.height+1,Math.max(l.dia,r.dia));
        int ht=Math.max(l.height,r.height)+1;
        
        return new Info(dia,ht);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Info ans=getDia(root);
        return ans.dia-1;
        
    }
}