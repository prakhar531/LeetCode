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
    public boolean findPath(TreeNode root, int value,StringBuilder sb ){
        if(root==null) return false;
        if(root.val==value) return true;

        sb.append('L');
        if(findPath(root.left,value,sb)) return true;
        sb.deleteCharAt(sb.length()-1);

        sb.append('R');
        if(findPath(root.right,value,sb)) return true;
        sb.deleteCharAt(sb.length()-1);
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start=new StringBuilder("");
        StringBuilder end=new StringBuilder("");

        findPath(root,startValue,start);
        findPath(root,destValue,end);

        int idx=0;
        while(idx<start.length()&&idx<end.length()&&start.charAt(idx)==end.charAt(idx)){
            idx++;
        }

        StringBuilder ans=new StringBuilder("");
        for(int i=0;i<start.length()-idx;i++){
            ans.append('U');
        }
        for(int i=idx;i<end.length();i++){
            ans.append(end.charAt(i));
        }
        return ans.toString();
    }
}