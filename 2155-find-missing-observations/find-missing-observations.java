// class Solution {
//     public int[] missingRolls(int[] rolls, int mean, int n) {
//         int m=rolls.length;
//         int rollSum=0;
//         for(int it:rolls) rollSum+=it;
//         int sum=(n+m)*mean-rollSum;
//         int ans[]=new int[n];
//         if(sum>n*6||sum<n) return new int[]{};

//         int avg=sum/n;
//         int rem=sum%n;
//         for(int i=0;i<n;i++){
//             ans[i]=avg;
//             if(rem!=0){
//                 ans[i]++;
//                 rem--;
//             }
//         }
//         return ans;
//     }
// }



class Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ret = new int[n];
        int sum = 0;
        for (int i : rolls) {
            sum += i;
        }
        int missingSum = mean * (n + rolls.length) - sum;
        if (missingSum > 6*n || missingSum < n) {
            return new int[]{};
        }
        int expectedAvg = missingSum/n, remainder = missingSum%n;

        for (int i = 0; i < remainder; i++) {
            ret[i] = expectedAvg + 1;
        }
        for (int i = remainder; i < n;i++) {
            ret[i] = expectedAvg;
        }
        return ret;
    }
}