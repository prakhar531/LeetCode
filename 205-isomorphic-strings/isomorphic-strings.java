class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        char sArr[]=s.toCharArray();
        char tArr[]=t.toCharArray();


        for(int i = 0 ; i<sArr.length; i++){
            char a = sArr[i];
            char b = tArr[i];
            if(map.containsKey(a)){
                 if(map.get(a).equals(b))
                    continue;
                else
                    return false;
            }else{
                if(!map.containsValue(b))
                    map.put(a,b);
                else 
                    return false;
                
            }
        }
        return true;
        
        
    
    }
}