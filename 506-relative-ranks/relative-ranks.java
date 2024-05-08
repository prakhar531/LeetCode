// class Solution {
//     public void reverse(int[] arr){
//         int i=0,j=arr.length-1;
//         while(i<j){
//             int temp=arr[i];
//             arr[i]=arr[j];
//             arr[j]=temp;
//             i++;
//             j--;
//         }
//     }
//     public String[] findRelativeRanks(int[] score) {
//         int arr[]=new int[score.length];
//         for(int i=0;i<score.length;i++){
//             arr[i]=score[i];
//         }
//         Arrays.sort(arr);
//         reverse(arr);
//         HashMap<Integer,String> map=new HashMap<>();
//         for(int i=0;i<score.length;i++){
//             map.put(arr[i],Integer.toString(i+1));
//         }
//         String[] ans=new String[score.length];
//         for(int i=0;i<score.length;i++){
//             ans[i]=map.get(score[i]);
//         }
//         for(int i=0;i<score.length;i++){
//             if(ans[i].equals("1")){
//                 ans[i]="Gold Medal";
//             } 
//             if(ans[i].equals("2")){
//                 ans[i]="Silver Medal";
//             } 
//             if(ans[i].equals("3")){
//                 ans[i]="Bronze Medal";
//             } 
//         }
//         return ans;
//     }
// }

// class Solution {
//     public String[] findRelativeRanks(int[] score) {
        
//         int n = score.length;
//         String[] res = new String[n];
        
//         PriorityQueue<Integer> pq = 
//             new PriorityQueue<>((a,b)->score[b]-score[a]);
        
//         for(int i=0;i<n;i++){
//             pq.add(i);
//         }
//         int i=1;
//         while(!pq.isEmpty()){
            
//             int idx = pq.poll();
            
//             if(i>3){
//                 res[idx] = Integer.toString(i);
//             }else if(i==1){
//                 res[idx] = "Gold Medal";
//             }else if(i==2){
//                 res[idx] = "Silver Medal";
//             }else if(i==3){
//                 res[idx] = "Bronze Medal";
//             }
//             i++;
//         }
        
//         return res;
        
//     }
// }

class Solution {
    private int findMax(int[] score) {
        int maxScore = 0;
        for (int s : score) {
            if (s > maxScore) {
                maxScore = s;
            }
        }
        return maxScore;
    }

    public String[] findRelativeRanks(int[] score) {
        int N = score.length;

        // Add the original index of each score to the array
        // Where the score is the key
        int M = findMax(score);
        int[] scoreToIndex = new int[M + 1];
        for (int i = 0; i < N; i++) {
            scoreToIndex[score[i]] = i + 1;
        }

        final String[] MEDALS = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        // Assign ranks to athletes
        String[] rank = new String[N];
        int place = 1;
        for (int i = M; i >= 0; i--) {
            if (scoreToIndex[i] != 0) {
                int originalIndex = scoreToIndex[i] - 1;
                if (place < 4) {
                    rank[originalIndex] = MEDALS[place - 1];
                } else {
                    rank[originalIndex] = String.valueOf(place);
                }
                place++;
            }
        }
        return rank;
    }
}