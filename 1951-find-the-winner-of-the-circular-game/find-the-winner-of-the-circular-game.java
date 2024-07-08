// class Solution {
//     public int findTheWinner(int n, int k) {
//         Queue<Integer> q=new LinkedList<>();
//         for(int i=1;i<=n;i++){
//             q.add(i);
//         }
//         while(q.size()!=1){
//             int temp=k;
//             while(temp!=1){
//                 int curr=q.remove();
//                 q.add(curr);
//                 temp--;
//             }
//             q.remove();
//         }
//         return q.remove();
//     }
// }

class Solution {
    public int findTheWinner(int n, int k) {
        if(n==1) return 1;
        return (findTheWinner(n-1,k)+k-1)%n+1;
    }
}