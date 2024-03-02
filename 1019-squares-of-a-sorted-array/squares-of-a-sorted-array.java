class Solution {
    public int[] sortedSquares(int[] nums) {

        // for(int i=0;i<nums.length;i++){
        //     nums[i]=(int)(nums[i]*nums[i]);
        // }
        // Arrays.sort(nums);
        // return nums;

        int l=0;
        int r=nums.length-1;
        int i=nums.length-1;
        int ans[]=new int[nums.length];

        while(i>=0 && l<=r){
            if(Math.abs(nums[l])<Math.abs(nums[r])){
                ans[i]=nums[r]*nums[r];
                r--;
            }else{
                ans[i]=nums[l]*nums[l];
                l++;
            }
            i--;
        }
        return ans;
    }
}