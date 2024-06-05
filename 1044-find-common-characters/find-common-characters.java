class Solution {
    public List<String> commonChars(String[] words) {
        int count[]=new int[26];
        int temp[]=new int[26];
        for(char ch:words[0].toCharArray()){
                int idx=ch-'a';
                count[idx]++;
        }

        for(String word:words){
            Arrays.fill(temp,0);
            for(char ch:word.toCharArray()){
                int idx=ch-'a';
                temp[idx]++;
            }
            for(int i=0;i<26;i++){
                if(count[i]==0) continue;
                if(temp[i]==0&&count[i]!=0){
                    count[i]=0;
                }else{
                    count[i]=Math.min(temp[i],count[i]);
                }

            }
        }

        List<String> ans=new ArrayList<>();
        for(int i=0;i<26;i++){
            while(count[i]!=0){
                ans.add(Character.toString(i+'a'));
                count[i]--;
            }
        }

        return ans;
    }
}