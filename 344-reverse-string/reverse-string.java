class Solution {
    public void reverseString(char[] s) {
        int j=s.length-1,i=0;
        while(i<j){
            char ch=s[i];
            s[i]=s[j];
            s[j]=ch;
            i++;
            j--;
        }
        
    }
}