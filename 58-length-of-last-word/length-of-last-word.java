class Solution {
    public int lengthOfLastWord(String s) {
    //     String newstr = s.trim();
    //     s=s.trim();
    //    int count=0;
    //     int i = s.length()-1;
    //     while(i >= 0 && newstr.charAt(i)!=' '){
    //         count++;
    //         i--;
    //     }
    //      return count;
        String str = s.trim();  
        int counter = 0;
        for(int i = str.length()-1; i>=0; i--){
            if(str.charAt(i) != ' ')
            {
                counter++;
            }else
            {
                break;
            }

        }
        return counter;
    }
}