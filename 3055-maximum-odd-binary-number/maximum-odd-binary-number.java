class Solution {
    public int counts(String s){
        int ans=0;
        for(int i=0;i<s.length();i++) if(s.charAt(i)=='1') ans++;
        return ans;
    }
    public String maximumOddBinaryNumber(String s) {
        int n=s.length();
        int count=counts(s);
        StringBuilder sb=new StringBuilder("");
        while(n>1){
            if(count>1){
                sb.append("1");
                count--;
            }else{
                sb.append("0");
            }
            n--;
        }
        sb.append("1");
        return sb.toString();
        
    }
}