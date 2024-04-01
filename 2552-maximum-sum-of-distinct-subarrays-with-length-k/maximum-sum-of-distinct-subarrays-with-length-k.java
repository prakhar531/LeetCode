class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        if(n<k) return 0;
        long ans=0;
        long sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        while(i<k-1){
            sum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            i++;
        }
        for(;i<n;i++){
            sum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.size()==k){
                ans=Math.max(ans,sum);
            }

            
            if(map.get(nums[i-k+1])==1) map.remove(nums[i-k+1]);
            else map.put(nums[i-k+1],map.get(nums[i-k+1])-1);

            sum-=nums[i-k+1];
        }
        return ans;
        
    }
}