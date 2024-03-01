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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return false;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = -1;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size(), prev = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();

                if(level == 0 && curr.val % 2 == 0){                        
                    return false;
                }
                if(i == 0){
                    if((level % 2 == 0 && curr.val % 2 == 1)
                    || (level % 2 == 1 && curr.val % 2 == 0)
                    ){                    
                        prev = curr.val;
                    }else{
                        return false;
                    }
                }
                else{                    
                    if (level % 2 == 1){
                        if(curr.val % 2 == 0 && prev > curr.val){
                            prev = curr.val;
                        }else{
                            return false;
                        }
                    }else{
                        if(curr.val % 2 == 1 && prev < curr.val){
                            prev = curr.val;
                        }else{
                            return false;
                        }
                    }
                }
                                        
                if(curr.left != null){
                    queue.add(curr.left);
                }
                
                if(curr.right != null){
                    queue.add(curr.right);
                }

            }
        }
        return true;
    }
}