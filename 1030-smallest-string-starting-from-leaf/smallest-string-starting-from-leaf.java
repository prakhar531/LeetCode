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
// class Solution {
//     String small="";
//     public String smallestFromLeaf(TreeNode root) {
//         solve(root,"");
//         return small;
//     }
//     public void solve(TreeNode root,String curr){
//         if(root==null) return;
//         curr=(char)(root.val+'a')+curr;
//         if(root.left==null&&root.right==null){
//             if(small=="" || small.compareTo(curr)>0){
//                 small=curr;
//             }
//         }
//         if(root.right!=null) solve(root.right,curr);
//         if(root.left!=null) solve(root.left,curr);
//     }
// }

class Solution {
    String small="";
    public String smallestFromLeaf(TreeNode root) {
        solve(root,new StringBuilder());
        return small;
    }
    public void solve(TreeNode root,StringBuilder sb){
        if(root==null) return;
        sb.insert(0,(char)(root.val+'a'));

        if(root.left==null&&root.right==null){
            if(small=="" || small.compareTo(sb.toString())>0){
                small=sb.toString();
            }
        }
        if(root.right!=null) solve(root.right,sb);
        if(root.left!=null) solve(root.left,sb);
        sb.deleteCharAt(0);
    }
}