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
    //public boolean isSameTree(TreeNode p, TreeNode q) {

//         if (p == null && q == null) {
//             return true;
//         }
//         if (p == null || q == null || p.val != q.val) {
//             return false;
//         }
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//     }

    public void preOrder(TreeNode root,List<Integer> li){
        if(root==null){
            li.add(Integer.MIN_VALUE);
            return;
        }
        li.add(root.val);
        preOrder(root.left,li);
        preOrder(root.right,li);
        return;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> l1=new ArrayList<>();
        preOrder(p,l1);
        List<Integer> l2=new ArrayList<>();
        preOrder(q,l2);
        if(l1.equals(l2)){
            return true;
        }
        return false;
    }
}