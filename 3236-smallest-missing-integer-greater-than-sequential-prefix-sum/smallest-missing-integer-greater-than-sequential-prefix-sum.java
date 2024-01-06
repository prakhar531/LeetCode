class Solution {
    public boolean ispresent(int[] nums, int sum){
        for(int it:nums){
            if(it==sum) return true;
        }
        return false;
    }
    
    public int missingInteger(int[] nums) {
        if(nums.length==1) return nums[0]+1;
        int sum=nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
            }else{
                break;
            }
        }
        
        if(!ispresent(nums,sum)){
            return sum;
        }else{
            while(ispresent(nums,sum)){
                sum+=1;
            }
        }
        return sum;
        
    }
}