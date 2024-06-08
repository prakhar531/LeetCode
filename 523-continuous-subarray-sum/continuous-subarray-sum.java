class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod=sum%k;
            if(i-map.getOrDefault(mod,i)>=2) return true;
            map.putIfAbsent(mod,i);
        }
        return false;
        
    }
}