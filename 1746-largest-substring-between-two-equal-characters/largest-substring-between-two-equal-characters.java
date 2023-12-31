class Solution {
    // public int count(String s,char ch,int ans){
    //     // int freq=0;
    //     // for(char c:s.toCharArray()){
    //     //     if(c==ch){
    //     //         ans=Math.max(ans,freq);
    //     //         freq=0;
    //     //     }else{
    //     //         freq++;
    //     //     }
    //     // }
    //     // return ans;

    //     int first=0;
    //     int last=0;
    //     for(int i=0;i<s.length();i++){
    //         if(s.charAt(i)==ch){
    //             first++;
    //             break;
    //         }
    //         first++;
    //     }
    //     for(int i=s.length()-1;i>=0;i--){
    //         if(s.charAt(i)==ch){
    //             last++;
    //             break;
    //         }
    //         last++;
    //     }
    //     return s.length()-first-last;
    // }

    // public int maxLengthBetweenEqualCharacters(String s) {
    //     Map<Character,Integer> map=new HashMap<>();
    //     for(char ch:s.toCharArray()){
    //         map.put(ch,map.getOrDefault(ch,0)+1);
    //     }
    //     int ans=Integer.MIN_VALUE;
    //     for(char ch:map.keySet()){
    //         if(map.get(ch)>1) ans=Math.max(ans,count(s,ch,ans));
    //     }
    //     if(ans==Integer.MIN_VALUE) return -1;

    //     return ans;        
    // }

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> firstIndex = new HashMap();
        int ans = -1;
        
        for (int i = 0; i < s.length(); i++) {
            if (firstIndex.containsKey(s.charAt(i))) {
                ans = Math.max(ans, i - firstIndex.get(s.charAt(i)) - 1);
            } else {
                firstIndex.put(s.charAt(i), i);
            }
        }
        
        return ans;
    }
}