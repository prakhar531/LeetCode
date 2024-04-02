class Solution {
    public boolean hasAllCodes(String s, int k) {
        // HashSet<String> set=new HashSet<>();
        // StringBuilder sb=new StringBuilder("");
        // for(int i=0;i<s.length();i++){
        //     sb.append(s.charAt(i));
        //     if(i>=k-1){
        //         set.add(sb.toString());
        //         sb.deleteCharAt(0);
        //     }
        // }
        // if(set.size()==Math.pow(2,k)) return true;
        // return false;

        HashSet<String> set=new HashSet<>();
        int temp=(int)Math.pow(2,k);
        for(int i=k-1;i<s.length();i++){
            String str=s.substring(i-k+1,i+1);
            set.add(str);
            if(set.size()==temp) return true;
        }
        
        return false;
    }
}