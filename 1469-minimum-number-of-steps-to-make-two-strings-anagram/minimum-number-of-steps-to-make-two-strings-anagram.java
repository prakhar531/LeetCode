class Solution {
    public int minSteps(String s, String t) {
        // Map<Character,Integer> smap=new HashMap<>();
        // for(char ch:s.toCharArray()) smap.put(ch,smap.getOrDefault(ch,0)+1);

        // Map<Character,Integer> tmap=new HashMap<>();
        // for(char ch:t.toCharArray()) tmap.put(ch,tmap.getOrDefault(ch,0)+1);

        // int ans=0;
        // for(char ch:tmap.keySet()){
        //     if(!smap.containsKey(ch)){
        //         ans+=tmap.get(ch);
        //     }else{
        //         if(tmap.get(ch)>smap.get(ch)) ans+=tmap.get(ch)-smap.get(ch);
        //     }
        // }
        // return ans;

        int[] charFreq = new int[26];

        for(char cur: s.toCharArray()) {
            charFreq[cur-'a']++;
        }

        for(char cur: t.toCharArray()) {
            charFreq[cur-'a']--;
        }

        int minSteps = 0;

        for(int idx=0; idx < 26; idx++) {
            if (charFreq[idx] > 0) {
                minSteps += charFreq[idx];
            }
        }

        return minSteps;

    }
}