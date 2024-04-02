class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(i>=k-1){
                set.add(sb.toString());
                sb.deleteCharAt(0);
            }
        }
        if(set.size()==Math.pow(2,k)) return true;
        return false;
        
    }
}