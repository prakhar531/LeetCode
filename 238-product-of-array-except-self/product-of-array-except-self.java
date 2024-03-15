class Solution {
    public int proforzero(int[] nums){
        int pro=1;
        int len=nums.length;
        int count=0;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                count++;
                continue;
            }else{
            pro *= nums[i];
            }
        }
        if(count==1){
            return pro;
        }else{
            return 0;
        }

    }
    public int[] productExceptSelf(int[] nums) {
        int pro=1;
        int len=nums.length;
        for(int i=0;i<len;i++){
            pro *= nums[i];
        }
        int ans[]=new  int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ans[i]=proforzero(nums);
            }else{
            ans[i]=(int)pro/nums[i];
            }
        }
        return ans;
                
        
    }
}