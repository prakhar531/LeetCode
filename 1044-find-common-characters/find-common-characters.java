// class Solution {
//     public List<String> commonChars(String[] words) {
//         int count[]=new int[26];
//         int temp[]=new int[26];
//         for(char ch:words[0].toCharArray()){
//                 int idx=ch-'a';
//                 count[idx]++;
//         }

//         for(String word:words){
//             Arrays.fill(temp,0);
//             for(char ch:word.toCharArray()){
//                 int idx=ch-'a';
//                 temp[idx]++;
//             }
//             for(int i=0;i<26;i++){
//                 if(count[i]==0) continue;
//                 if(temp[i]==0&&count[i]!=0){
//                     count[i]=0;
//                 }else{
//                     count[i]=Math.min(temp[i],count[i]);
//                 }

//             }
//         }

//         List<String> ans=new ArrayList<>();
//         for(int i=0;i<26;i++){
//             while(count[i]!=0){
//                 ans.add(Character.toString(i+'a'));
//                 count[i]--;
//             }
//         }

//         return ans;
//     }
// }
class Solution {
   public List<String> commonChars(String[] words) {
        int[] last = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            last = intersection(last, count(words[i]));
        }
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }
    int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }
    int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) t[c - 'a']++;
        return t;
    }
}
