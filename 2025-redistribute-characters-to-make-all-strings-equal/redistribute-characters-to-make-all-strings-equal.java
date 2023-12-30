class Solution {
    public boolean makeEqual(String[] words) {
        int n=words.length;
        if(n==1) return true;

        int totalCharCount=0;
        for(String str:words){
            totalCharCount+=str.length();
        }
        if(totalCharCount%n!=0) return false;

        int arr[]=new int[26];
        for(String str:words){
            for(char ch:str.toCharArray()){
                arr[ch-'a']++;
            }
        }
        for(int it:arr){
            if(it%n!=0) return false;
        }
        return true;
    }
}