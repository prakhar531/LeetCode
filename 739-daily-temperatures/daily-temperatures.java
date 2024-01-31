// class Solution {
//     public int[] dailyTemperatures(int[] temp) {
//         int n=temp.length;
//         int ans[]=new int[n];
//         Stack<Integer> s=new Stack<>();
//         for(int i=n-1;i>=0;i--){
//             while(!s.isEmpty() && temp[s.peek()]<=temp[i]){
//                 s.pop();
//             }
//             if(s.isEmpty()){
//                 ans[i]=0;
//             }else{
//                 ans[i]=s.peek()-i;
//             }
//             s.push(i);
//         }
//         return ans;
//     }
// }



class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        int[] res = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; --i) {
            if (deque.isEmpty()) {
                deque.offerFirst(i);
                res[i] = 0;
            } else {
                while (!deque.isEmpty() && temperatures[i] >= temperatures[deque.peekFirst()]) {
                    deque.pollFirst();
                }

                if (deque.isEmpty()) {
                    res[i] = 0;
                } else {
                    res[i] = deque.peekFirst() - i;
                }

                deque.offerFirst(i);
            }
        }

        return res;
    }
}

