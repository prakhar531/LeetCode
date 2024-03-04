class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int s=0,e=tokens.length-1;
        int ans=Integer.MIN_VALUE,curr=0;
        if(tokens.length==0|| tokens[s]>power) return 0;

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