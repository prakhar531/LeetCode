class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // int preSum[]=new int[nums.length];
        // preSum[0]=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     preSum[i]=preSum[i-1]+nums[i];
        // }
        // int ans=0;
        // for(int i=0;i<nums.length;i++){
        //     int st=i;
        //     for(int j=i;j<nums.length;j++){
        //         int sum=st==0?preSum[j]:preSum[j]-preSum[i-1];
        //         if(sum==goal) ans++;
        //     }
        // }
        // return ans;

        int n = nums.length;
        int result = 0;
        int prefixSum = 0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int i=0; i<n; i++){
            prefixSum += nums[i];
            result += map.getOrDefault(prefixSum - goal, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum,0) + 1);
        }
        return result;
    }
}