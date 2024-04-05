class Solution {
    public String makeGood(String str) {
        Stack<Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(s.isEmpty()){
                s.push(ch);
                continue;
            }
            if(ch==s.peek()){
                s.push(ch);
                continue;
            }
            if(Character.toUpperCase(ch)==s.peek() || Character.toLowerCase(ch)==s.peek()){
                s.pop();
               
            }else{
                s.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder("");
        while(!s.isEmpty()){
            sb.append(s.pop());
        } 
        return sb.reverse().toString();
    }
}