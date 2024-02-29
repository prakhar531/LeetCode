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
//     public boolean checkOdd(TreeNode root,ArrayList<Integer> list){
//         for(int i=0;i<list.size()-1;i++){
//             if(list.get(i)<list.get(i+1)) return false;
//         }
//         return true;
//     }

//     public boolean checkEven(TreeNode root,ArrayList list){
//         for(int i=0;i<list.size()-1;i++){
//             if((int) list.get(i) > (int) list.get(i + 1)) return false;
//         }
//         return true;
//     }

//     public boolean isEvenOddTree(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         int level=-1;

//         while (!q.isEmpty()) {
//             ArrayList<Integer> list=new ArrayList<>();
//             int count = q.size();
            
//             for (int i = 0; i < count; i++) {
//                 TreeNode curr = q.poll();
//                 list.add(curr.val);
//                 if (curr.left != null)
//                     q.add(curr.left);
//                 if (curr.right != null)
//                     q.add(curr.right);
//             }

//             level++;
//             if(level%2==0){
//                 if(!checkEven(root,list)) return false;
//             }else{
//                 if(!checkOdd(root,list)) return false;
//             }

//         }
//         return true;
        
//     }
// }

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
       Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        int res = 1;
        int c = 0;
        int prev = 0;
        while(!que.isEmpty()){
            if(res%2==0)
                prev = Integer.MAX_VALUE;
            else
                prev = Integer.MIN_VALUE;
            while(que.peek()!=null) {
                if(que.peek().val%2!=res%2){
                    return false;
                }
                if(res%2==0 && prev<=que.peek().val){
                    return false;
                }

                if(res%2!=0 && prev>=que.peek().val)
                    return false;
                if (que.peek().left != null)
                    que.add(que.peek().left);
                if (que.peek().right != null)
                    que.add(que.peek().right);
                prev = que.poll().val;
            }
            que.poll();
            if(que.isEmpty()){
                break;
            }
          res++;
            que.add(null);

        }
        return true;
    }
}