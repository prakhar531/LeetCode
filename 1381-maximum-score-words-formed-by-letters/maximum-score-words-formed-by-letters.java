// class Solution {
//     int ans=0;
//     public int maxScoreWords(String[] words, char[] letters, int[] score) {
//         int count[]=new int[26];
//         for(char letter:letters){
//             count[letter-'a']++;
//         }
//         solve(words,score,count,0,0);
//         return ans;
//     }
//     public void solve(String[] words,int[] score,int[] count,int idx,int sum){
//         if(idx==words.length){
//             ans=Math.max(ans,sum);
//             return;
//         }

//         solve(words,score,count,idx+1,sum);
//         if(check(count,words[idx])){
//             for(char ch:words[idx].toCharArray()){
//                 count[ch-'a']--;
//                 sum+=score[ch-'a'];
//             }
//             solve(words,score,count,idx+1,sum);
//             for(char ch:words[idx].toCharArray()){
//                 count[ch-'a']++;
//             }
//         }
//     }
//     public boolean check(int[] count,String str){
//         int curr[]=new int[26];
//         for(char ch:str.toCharArray()){
//             curr[ch-'a']++;
//         }
//         for(int i=0;i<26;i++){
//             if(count[i]<curr[i]) return false;
//         }
//         return true;
//     }
// }

// class Solution {
    
//     public int maxScoreWords(String[] words, char[] letters, int[] score) {
//         int max=0;
//         int count[]=new int[26];
//         for(char letter:letters){
//             count[letter-'a']++;
//         }
        
//         int set[]=new int[26];
//         int n=words.length;
//         for(int mask=0; mask<(1<<n); mask++){
//             Arrays.fill(set,0);
//             for(int i=0;i<n;i++){
//                 if(((mask)&(1<<i))>0){
//                     int l=words[i].length();
//                     for(int j=0;j<l;j++){
//                         set[words[i].charAt(j)-'a']++;
//                     }
//                 }
//             }
//             max=Math.max(max,findScore(set,count,score));
//         }
//         return max;
//     }
//     public int findScore(int[] set,int[] count,int[] score){
//         int total=0;
//         for(int i=0;i<26;i++){
//             total+=set[i]*score[i];

//             if(count[i]<set[i]) return 0;
//         }
//         return total;
//     }
// }

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int [] frequency = new int[26];
        for(int i = 0;i<letters.length;i++){
            frequency[letters[i]-'a']++;
        }
        int result = backtrack(words,frequency,score,0);
        return result;
        
        
    }
    public static int backtrack(String[] words, int[] frr, int[] score,int idx){
        if(idx == words.length){
            return 0;
        }
        int scoreOfaWord =0;
        int no = backtrack(words,frr,score,idx+1);
        boolean isValid = true;
        for(int i =0;i<words[idx].length();i++){
            char ch = words[idx].charAt(i);
            if(frr[ch-'a']<=0){
                isValid = false;
            }
            frr[ch-'a']--;
            scoreOfaWord += score[ch-'a'];
            
        }
        int yes =0;
        if(isValid){
            yes = scoreOfaWord + backtrack(words,frr,score,idx+1);
        }
        for(int i =0;i<words[idx].length();i++){
            frr[words[idx].charAt(i)-'a']++;
        }
        return Math.max(no,yes);
        
        
    }
}