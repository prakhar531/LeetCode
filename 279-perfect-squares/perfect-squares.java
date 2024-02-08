// class Solution {
//     public int numSquares(int n) {
        
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,Integer.MAX_VALUE);
//         dp[0]=0;
//         int count=1;
//         while(count*count<=n){
//             int sq=count*count;
//             for(int i=sq;i<=n;i++){
//                 dp[i]=Math.min(dp[i-sq]+1,dp[i]);
//             }
//             count++;
//         }
//         return dp[n];
//     }
// }

class Solution {
    public int numSquares(int n) {
         int sqrt = (int) Math.sqrt(n);

        if (sqrt * sqrt == n)
            return 1;

        while (n % 4 == 0)
            n = n / 4;

        if (n % 8 == 7) return 4;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            int base = (int) Math.sqrt(n - square);

            if (base * base == n - square) return 2;
        }

        return 3;
    }
}