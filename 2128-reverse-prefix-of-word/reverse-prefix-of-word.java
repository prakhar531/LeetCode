class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb=new StringBuilder("");
        boolean flag=true;
        for(char c:word.toCharArray()){
            sb.append(c);
            if(ch==c && flag){
                sb.reverse();
                flag=false;
            }
        }
        return sb.toString();
    }
}