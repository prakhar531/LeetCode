class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;
        int ans=0;
        int temp=threshold*k;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(i>=k-1){
                if(sum>=temp) ans++;
                sum-=arr[i-k+1];
            }
        }
        return ans;
    }
}