class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set=new HashSet<>();
        char sArr[]=s.toCharArray();
        char tArr[]=t.toCharArray();


        for(int i = 0 ; i<sArr.length; i++){
            char a = sArr[i];
            char b = tArr[i];
            if(map.containsKey(a)){
                 if(!map.get(a).equals(b))
                    return false;
            }else{
                if(set.contains(b)){
                    return false;
                }
                map.put(a,b);
                set.add(b);
                
                
            }
        }
        return true;
        
        
    
    }
}