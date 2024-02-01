class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int row=nums.length/3;
        int ans[][]=new int[row][3];
        int idx=0;
        int empty[][]={};
        
        for(int i=0;i<nums.length-2;i=i+3){
            if(nums[i+2]-nums[i]>k) return empty;
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<3;j++){
                ans[i][j]=nums[idx++];
            }
        }
        return ans;
    }
}