class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int left=0,right=0;right<nums.length;right++){
            int curr=nums[right];
            while(left<=right && map.containsKey(curr) && map.get(curr)>=k){
                int lele=nums[left++];
                int val=map.get(lele);
                map.put(lele,val-1);
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}