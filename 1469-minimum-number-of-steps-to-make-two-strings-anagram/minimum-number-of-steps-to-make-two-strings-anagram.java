class Solution {
    public int minSteps(String s, String t) {
        Map<Character,Integer> smap=new HashMap<>();
        for(char ch:s.toCharArray()) smap.put(ch,smap.getOrDefault(ch,0)+1);

        Map<Character,Integer> tmap=new HashMap<>();
        for(char ch:t.toCharArray()) tmap.put(ch,tmap.getOrDefault(ch,0)+1);

        int ans=0;
        for(char ch:tmap.keySet()){
            if(!smap.containsKey(ch)){
                ans+=tmap.get(ch);
            }else{
                if(tmap.get(ch)>smap.get(ch)) ans+=tmap.get(ch)-smap.get(ch);
            }
        }
        return ans;
    }
}