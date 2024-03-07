class Solution {
    public String mergeAlternately(String word1, String word2) {
        // StringBuilder sb=new StringBuilder("");
        // int i=0,j=0;
        // while(i<word1.length()&&j<word2.length()){
        //     sb.append(word1.charAt(i++));
        //     sb.append(word2.charAt(j++));
        // }
        // while(i<word1.length()){
        //     sb.append(word1.charAt(i++));
        // }
        // while(j<word2.length()){
        //     sb.append(word2.charAt(j++));
        // }
        // return sb.toString();

        StringBuilder sb=new StringBuilder("");
        int minL=Math.min(word1.length(),word2.length());
        for(int i=0;i<minL;i++){
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        return sb.append(word1.substring(minL)).append(word2.substring(minL)).toString();
        

    }
}