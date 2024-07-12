class Solution {
    public int maximumGain(String s, int x, int y) {
        String high=x>y?"ab":"ba";
        String low=x<y?"ab":"ba";

        int highScore=x>y?x:y;
        int lowScore=y>x?x:y;

        String firstPass=solve(s,high);
        int ans=0;

        ans+=((s.length()-firstPass.length())/2)*highScore;
        String secondPass=solve(firstPass,low);
        ans+=((firstPass.length()-secondPass.length())/2)*lowScore;
        return ans;
    }

    public String solve(String s,String str){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==str.charAt(1)&& !stack.isEmpty() && stack.peek()==str.charAt(0)){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder("");
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}