class Solution {
    public int getMin(int []temp,int x){
        for(int i=0;i<101;i++){
            if(temp[i]>0){
                x-=temp[i];
                if(x<=0) return i-50;
            }
        }
        return 1;
    }
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length,j=0;
        int freq[]=new int[101];
        int ans[]=new int[n-k+1];

        for(int i=0;i<n;i++){
            freq[nums[i]+50]++;
            if(i>=k-1){
                int curr=getMin(freq,x);
                ans[j++]=curr>0?0:curr;
                freq[nums[i-k+1]+50]--;
            }
        }
        return ans;
    }
}