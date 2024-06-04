class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(Character ch:s.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);
        boolean flag=false;
        int ans=0;
        for(Character ch:map.keySet()){
            int it=map.get(ch);
            if(it%2==0){
                ans+=it;
            } 
            else{
                if(!flag) flag=true;
                ans+=it-1;
            } 
        }

        return flag?ans+1:ans;
        
    }
}