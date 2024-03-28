class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        // int max=0;
        // HashMap<Integer,Integer> map=new HashMap<>();

        // for(int left=0,right=0;right<nums.length;right++){
        //     int curr=nums[right];
        //     while(left<=right && map.containsKey(curr) && map.get(curr)>=k){
        //         int lele=nums[left++];
        //         int val=map.get(lele);
        //         map.put(lele,val-1);
        //     }
        //     map.put(curr,map.getOrDefault(curr,0)+1);
        //     max=Math.max(max,right-left+1);
        // }
        // return max;

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int num:nums){
            min=Math.min(num,min);
            max=Math.max(num,max);
        }

        int count[]=new int[max-min+1];
        int left=0;
        int ans=0;
        for(int right=0;right<nums.length;right++){
            count[nums[right]-min]++;
            while(count[nums[right]-min]>k){
                count[nums[left]-min]--;
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}