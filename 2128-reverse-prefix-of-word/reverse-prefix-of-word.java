class Solution {
    public String reversePrefix(String word, char ch) {
        // StringBuilder sb=new StringBuilder("");
        // boolean flag=true;
        // for(int i=0;i<word.length();i++){
        //     char c=word.charAt(i);
        //     sb.append(c);
        //     if(ch==c && flag){
        //         sb.reverse();
        //         flag=false;
        //     }
        // }
        // return sb.toString();

        int firstOccurence = word.indexOf(ch);
        if(firstOccurence == -1){
            return word;
        }
        
        StringBuilder prefix = new StringBuilder(word.substring(0, firstOccurence+1));
        return prefix.reverse().toString() + word.substring(firstOccurence+1);
    }
}