class Solution {
    public void sortColors(int[] nums) {
        // Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;

        for(int i=0;i<=right;){
            if(nums[i]==0){
                swap(nums,i++,left++);
            }else if(nums[i]==1){
                i++;
            }else{
                swap(nums,i,right--);
            }
        }

    }

    public void swap(int nums[], int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}