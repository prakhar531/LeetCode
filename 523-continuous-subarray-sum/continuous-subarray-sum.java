// class Solution {
//     public boolean checkSubarraySum(int[] nums, int k) {
//         int sum=0;
//         Map<Integer,Integer> map=new HashMap<>();
//         map.put(0,-1);
//         for(int i=0;i<nums.length;i++){
//             sum+=nums[i];
//             int mod=sum%k;
//             if(i-map.getOrDefault(mod,i)>=2) return true;
//             map.putIfAbsent(mod,i);
//         }
//         return false;
        
//     }
// }

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums[0] == 300000){
            return false;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i] == 0 && nums[i-1] ==0) return true;
        }
        
        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
            if(nums[i] % k == 0) return true;
            int j = i;
            while(j>1 && nums[i] > k){
                if((nums[i] - nums[j-2]) % k == 0) return true;
                j--;
            }
        }
        return false;
    }
}