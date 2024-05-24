class Solution {
    int ans=0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int count[]=new int[26];
        for(char letter:letters){
            count[letter-'a']++;
        }
        solve(words,score,count,0,0);
        return ans;
    }
    public void solve(String[] words,int[] score,int[] count,int idx,int sum){
        if(idx==words.length){
            ans=Math.max(ans,sum);
            return;
        }

        solve(words,score,count,idx+1,sum);
        if(check(count,words[idx])){
            for(char ch:words[idx].toCharArray()){
                count[ch-'a']--;
                sum+=score[ch-'a'];
            }
            solve(words,score,count,idx+1,sum);
            for(char ch:words[idx].toCharArray()){
                count[ch-'a']++;
            }
        }
    }
    public boolean check(int[] count,String str){
        int curr[]=new int[26];
        for(char ch:str.toCharArray()){
            curr[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(count[i]<curr[i]) return false;
        }
        return true;
    }
}