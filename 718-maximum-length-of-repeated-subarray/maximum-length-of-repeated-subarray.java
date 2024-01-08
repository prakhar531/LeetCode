class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0) return 0;
        int dp[][]=new int[nums1.length+1][nums2.length+1];
        int ans=0;

        for(int i=1;i<nums1.length+1;i++){
            for(int j=1;j<nums2.length+1;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
}