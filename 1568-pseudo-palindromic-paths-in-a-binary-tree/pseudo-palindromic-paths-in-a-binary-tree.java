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
    int ans=0;
    public boolean check(int arr[]){
        int count=0;
        for(int i=1;i<10;i++){
            if(arr[i]%2!=0){
               if(count!=0) return false;
               count++;
            }
        }
        return true;
    }
    public void solve(TreeNode root,int arr[]){
        if(root==null) return;
        if(root.left==null && root.right==null){
            arr[root.val]++;
            if(check(arr)) ans++;
            arr[root.val]--;
            return;
        } 
        arr[root.val]++;
        solve(root.left,arr);
        solve(root.right,arr);
        arr[root.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root.left==null && root.right==null) return 1;
        int arr[]=new int[10];
        solve(root,arr);
        return ans;
    }
    
}