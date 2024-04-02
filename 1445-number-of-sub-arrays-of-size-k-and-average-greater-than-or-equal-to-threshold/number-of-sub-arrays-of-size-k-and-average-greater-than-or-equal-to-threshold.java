class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(i>=k-1){
                if(sum>=threshold*k) ans++;
                sum-=arr[i-k+1];
            }
        }
        return ans;
    }
}