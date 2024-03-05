class Solution {
    public int minimumLength(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                while(start<end-1 && s.charAt(start)==s.charAt(start+1)){
                    start++;
                }
                while(end>start+1 && s.charAt(end)==s.charAt(end-1)){
                    end--;
                }
                start++;
                end--;
            }else{
                return end-start+1;
            }
        }
        return end-start+1;
    }
}