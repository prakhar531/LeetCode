class Solution {
    public long largestPerimeter(int[] nums) {
        long prefix[]=new long[nums.length];
        Arrays.sort(nums);
        long ans=0;

        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=nums[i]+prefix[i-1];
        }
        
        for(int i=nums.length-1;i>=2;i--){
            if(nums[i]<prefix[i-1]){
                ans=prefix[i];
                return ans;
            } 
        }

        return -1;
    }
}