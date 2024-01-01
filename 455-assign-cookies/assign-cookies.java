class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Arrays.sort(g);
        // Arrays.sort(s);
        // int ans=0,j=0;

        // for(int i=0;i<g.length;i++){
        //     while(j<s.length&&s[j]<g[i]){
        //         j++;
        //     }
        //     if(j<s.length&&s[j]>=g[i]){
        //         ans++;
        //         j++;
        //     } 
        // }
        // return ans;
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        int n=g.length,m=s.length;
        while(i<n&& j<m)
        {
            if(g[i]<=s[j])
            {
                count++;
                i++;j++;
            }
            else j++;
        }
        return count;
    }
}