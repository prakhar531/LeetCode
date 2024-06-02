class Solution {
    public int minimumChairs(String s) {
        int chair=0,curr=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='E'){
                if(chair<=curr) chair++;
                curr++;
            }else{
                chair=Math.max(chair,--curr);
                
            } 
        }
        return chair;
    }
}