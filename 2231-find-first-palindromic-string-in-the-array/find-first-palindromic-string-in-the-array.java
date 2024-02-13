class Solution {
    public boolean checkPalindrom(String str){
        int i=0,j=str.length()-1;
        while(i<=j){
            if(str.charAt(i++)!=str.charAt(j--)) return false;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String str:words){
            if(checkPalindrom(str)) return str;
        }
        return "";
    }
}