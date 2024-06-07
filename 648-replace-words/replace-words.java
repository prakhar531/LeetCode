class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set=new HashSet<>();
        for(String s: dictionary){
            set.add(s);
        }

        String[] st=sentence.split(" ");
        StringBuilder sb=new StringBuilder(""); 

        for(String str:st){
            StringBuilder curr=new StringBuilder("");
            int i=0;
            for(;i<str.length();i++){
                curr.append(str.charAt(i));
                if(set.contains(curr.toString())){
                    sb.append(curr.toString());
                    break;
                }
            }
            if(i==str.length()) sb.append(str);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
        
    }
}