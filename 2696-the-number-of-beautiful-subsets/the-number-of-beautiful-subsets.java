class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.sort(nums);
        return solve(nums,k,map,0)-1;
    }
    public int solve(int[] nums,int k,HashMap<Integer,Integer> map,int i){
        if(i==nums.length) return 1;

        int total=solve(nums,k,map,i+1);
        if(!map.containsKey(nums[i]-k)){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            total+=solve(nums,k,map,i+1);
            map.put(nums[i],map.get(nums[i])-1);
            if(map.get(nums[i])==0) map.remove(nums[i]);
        }
        return total;
    }
}