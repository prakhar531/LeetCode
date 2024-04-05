// class Solution {
//     public String makeGood(String str) {
//         if (s.length() == 0 || s.length() == 1)
//             return s;
//         Stack<Character> s=new Stack<>();

//         for(int i=0;i<str.length();i++){
//             char ch=str.charAt(i);
//             if(s.isEmpty()){
//                 s.push(ch);
//                 continue;
//             }
//             if(ch==s.peek()){
//                 s.push(ch);
//                 continue;
//             }
//             if(Character.toUpperCase(ch)==s.peek() || Character.toLowerCase(ch)==s.peek()){
//                 s.pop();
               
//             }else{
//                 s.push(ch);
//             }
//         }
//         StringBuilder sb=new StringBuilder("");
//         while(!s.isEmpty()){
//             sb.append(s.pop());
//         } 
//         return sb.reverse().toString();
//     }
// }

class Solution {
    public String makeGood(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;

        StringBuilder sb = new StringBuilder();

        sb.append(s);

        int i = 0;

        while (i < sb.length() - 1)
        {
            char leftChar = sb.charAt(i);
            char rightChar = sb.charAt(i + 1);

            if (Math.abs(leftChar - rightChar) == 32)
            {
                sb.delete(i, i + 2);
                if (i > 0)
                    i--;
            }
            else
            {
                i++;
            } 
        }

        return sb.toString();
    }
}