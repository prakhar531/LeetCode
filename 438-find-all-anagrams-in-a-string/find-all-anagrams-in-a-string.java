class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        if(p.length()>s.length()) return ans;

        Map<Character,Integer> sMap=new HashMap<>();
        Map<Character,Integer> pMap=new HashMap<>();

        for(int i=0;i<p.length();i++){
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0)+1);
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
        }

        if(sMap.equals(pMap)) ans.add(0);

        int start=0,end=p.length();
        while(end<s.length()){
            char add=s.charAt(end++);
            sMap.put(add,sMap.getOrDefault(add,0)+1);
            char rem=s.charAt(start++);
            sMap.put(rem,sMap.get(rem)-1);
            if(sMap.get(rem)==0) sMap.remove(rem);

            if(sMap.equals(pMap)) ans.add(start);         
        }
        return ans;
    }
}