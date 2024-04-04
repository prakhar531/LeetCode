class Solution {
    public int maxDepth(String s) {
        int ans=0,temp=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                temp++;
            }else if(ch==')'){
                ans=Math.max(temp,ans);
                temp--;
            }
        }
        return ans;
    }
}