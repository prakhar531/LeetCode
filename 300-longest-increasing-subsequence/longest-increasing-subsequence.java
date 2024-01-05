class Solution {
    // public int lcs(int arr[],int nums[]){
    //     int n=arr.length;
    //     int m=nums.length;
    //     int dp[][]=new int[n+1][m+1];

    //     for(int i=1;i<n+1;i++){
    //         for(int j=1;j<m+1;j++){
    //             if(arr[i-1]==nums[j-1]){
    //                 dp[i][j]=dp[i-1][j-1]+1;
    //             }else{
    //                 dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
    //             }
    //         }
    //     }

    //     return dp[n][m];
    // }
    // public int lengthOfLIS(int[] nums) {
    //     HashSet<Integer> set=new HashSet<>();
    //     for(int i=0;i<nums.length;i++) set.add(nums[i]);

    //     int arr[]=new int[set.size()];
    //     int i=0;
    //     for(int num:set) arr[i++]=num;
        
    //     Arrays.sort(arr);
    //     return lcs(arr,nums);
        
    // }

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}