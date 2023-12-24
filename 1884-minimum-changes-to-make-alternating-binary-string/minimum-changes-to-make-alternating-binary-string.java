class Solution {
    public int minOperations(String s) {
        // int ans=0;
        // char prev=s.charAt(0);
        // for(int i=1;i<s.length();i++){
        //     char curr=s.charAt(i);
        //     if(prev!=curr){
        //         prev=curr;
        //         continue;
        //     }else{
        //         prev=(prev=='1')?'0':'1';
        //         ans++;
        //     }
        // }
        // return Math.min(ans,s.length()-ans);

        int res = 0, n = s.length();
        for (int i = 0; i < n; ++i)
            if (s.charAt(i) - '0' != i % 2) res++;
        return Math.min(res, n - res);
    }
}