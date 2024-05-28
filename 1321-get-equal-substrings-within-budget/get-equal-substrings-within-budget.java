//Sliding window
// class Solution {
//     public int equalSubstring(String s, String t, int maxCost) {
//         int i=0,j=0;
//         int max=0,curr=0;
//         for(;j<s.length();j++){
//             curr+=Math.abs(s.charAt(j)-t.charAt(j));
//             if(curr>maxCost){
//                 curr-=Math.abs(s.charAt(i)-t.charAt(i));
//                 i++;
//             }
//             max=Math.max(max,j-i+1);
//         }
//         return max;
        
//     }
// }

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int N = s.length();
        
        int maxLen = 0;
        // Starting index of the current substring
        int start = 0;
        // Cost of converting the current substring in s to t
        int currCost = 0;
        
        for (int i = 0; i < N; i++) {
            // Add the current index to the substring
            currCost += Math.abs(s.charAt(i) - t.charAt(i));
            
            // Remove the indices from the left end till the cost becomes less than allowed
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }
}