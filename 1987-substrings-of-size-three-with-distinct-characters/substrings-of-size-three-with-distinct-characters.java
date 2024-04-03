class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length()<3) return 0;

        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        char charr[]=s.toCharArray();
        for(int i=0;i<charr.length;i++){

            map.put(charr[i],map.getOrDefault(charr[i],0)+1);
            if(i>=2){
                if(map.size()==3) ans++;

                if(map.get(charr[i-2])==1) map.remove(charr[i-2]);
                else map.put(charr[i-2],map.get(charr[i-2])-1);
            }
        }
        return ans;
    }
}