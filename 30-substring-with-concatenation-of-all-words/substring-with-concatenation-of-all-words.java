class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map=new HashMap<>();
        for(String str: words){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        List<Integer> ans=new ArrayList<>();
        int n=s.length(), num=words.length, len=words[0].length();

        for(int i=0;i<n-num*len+1;i++){
            Map<String, Integer> seen=new HashMap<>();
            int j=0;
            while(j<num){
                String word=s.substring(i+j*len,i+(j+1)*len);
                if(map.containsKey(word)){
                    seen.put(word,seen.getOrDefault(word,0)+1);
                    if(seen.get(word)>map.getOrDefault(word,0)){
                        break;
                    }
                }else{
                    break;
                }
                j++;
            }
            if(j==num) ans.add(i);
        }
        return ans;
        
    }
}