// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//         // Arrays.sort(g);
//         // Arrays.sort(s);
//         // int ans=0,j=0;

//         // for(int i=0;i<g.length;i++){
//         //     while(j<s.length&&s[j]<g[i]){
//         //         j++;
//         //     }
//         //     if(j<s.length&&s[j]>=g[i]){
//         //         ans++;
//         //         j++;
//         //     } 
//         // }
//         // return ans;
//         int count=0;
//         Arrays.sort(g);
//         Arrays.sort(s);
//         int i=0,j=0;
//         int n=g.length,m=s.length;
//         while(i<n&& j<m)
//         {
//             if(g[i]<=s[j])
//             {
//                 count++;
//                 i++;j++;
//             }
//             else j++;
//         }
//         return count;
//     }
// }

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //O(nolgn)
        //S(1)
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1, j = s.length - 1;
        int c = 0;
        while(i >= 0 && j >= 0){
            if(g[i] <= s[j]){
                j--;
                c++;
            }
            i--;
        }

        return c;
    }
}