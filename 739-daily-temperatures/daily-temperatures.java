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



// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         Deque<Integer> deque = new ArrayDeque<>();
        
//         int[] res = new int[temperatures.length];

//         for (int i = temperatures.length - 1; i >= 0; --i) {
//             if (deque.isEmpty()) {
//                 deque.offerFirst(i);
//                 res[i] = 0;
//             } else {
//                 while (!deque.isEmpty() && temperatures[i] >= temperatures[deque.peekFirst()]) {
//                     deque.pollFirst();
//                 }

//                 if (deque.isEmpty()) {
//                     res[i] = 0;
//                 } else {
//                     res[i] = deque.peekFirst() - i;
//                 }

//                 deque.offerFirst(i);
//             }
//         }

//         return res;
//     }
// }

// haven't checked yet, seems unnecessarily complicated

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        
        int hottest = 0;
        
        int answer[] = new int[n];
        
        for (int currDay = n - 1; currDay >= 0; currDay--) {

            int currentTemp = temperatures[currDay];

            // hottest temp seen so far moving from the right
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            
            int days = 1;

            while (temperatures[currDay + days] <= currentTemp) {
                // Use information from answer to search for the next warmer day
                days += answer[currDay + days];
            }

            answer[currDay] = days;
        }
        
        return answer;
    }
}
