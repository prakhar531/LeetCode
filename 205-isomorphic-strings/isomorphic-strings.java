class Solution {
    public boolean isIsomorphic(String s, String t) {


        HashMap<Character,Character> map1=new HashMap<>();
        map1.put(s.charAt(0),t.charAt(0));
        HashMap<Character,Character> map2=new HashMap<>();
        map2.put(t.charAt(0),s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(map1.containsKey(s.charAt(i)) && map1.get(s.charAt(i))!=t.charAt(i)){
                return false;
            }else{
                map1.put(s.charAt(i),t.charAt(i));
            }
            if(map2.containsKey(t.charAt(i)) && map2.get(t.charAt(i))!=s.charAt(i)){
                return false;
            }else{
                map2.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
        // if(s == null || s.length() <= 1) return true;
        // HashMap<Character, Character> map = new HashMap<Character, Character>();
        // for(int i = 0 ; i< s.length(); i++){
        //     char a = s.charAt(i);
        //     char b = t.charAt(i);
        //     if(map.containsKey(a)){
        //          if(map.get(a).equals(b))
        //             continue;
        //         else
        //             return false;
        //     }else{
        //         if(!map.containsValue(b))
        //             map.put(a,b);
        //         else 
        //             return false;
                
        //     }
        // }
        // return true;
        
    
    }
}