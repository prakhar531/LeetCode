//Sliding window
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i=0,j=0;
        int max=0,curr=0;
        for(;j<s.length();j++){
            curr+=Math.abs(s.charAt(j)-t.charAt(j));
            
            if(curr>maxCost){
                curr-=Math.abs(s.charAt(i)-t.charAt(i));
                i++;
            }
            max=Math.max(max,j-i+1);
        }
        return max;
        
    }
}