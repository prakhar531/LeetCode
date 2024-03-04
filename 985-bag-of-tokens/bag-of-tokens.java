class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens.length==0) return 0;
        Arrays.sort(tokens);
        if(tokens[0]>power) return 0;
        int s=0,e=tokens.length-1;
        int ans=Integer.MIN_VALUE,curr=0;

        while(s<=e){
            if(tokens[s]<=power){
                power-=tokens[s];
                s++;
                curr++;
                ans=Math.max(ans,curr);
            }else{
                power+=tokens[e];
                e--;
                curr--;
            }
        }
        return ans<0?0:ans;
    }
}