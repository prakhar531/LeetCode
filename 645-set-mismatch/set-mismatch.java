class Solution {
    public int[] findErrorNums(int[] nums) {
        int arr[]=new int[nums.length];
        int miss=0;
        int dup=0;
        for(int i=0;i<nums.length;i++){
            arr[nums[i]-1]++;
        }
        for(int i=0;i<nums.length;i++){
            if(arr[i]==2) dup=i+1; 
            if(arr[i]==0) miss=i+1;
        }

        return new int[]{dup,miss};
    }
}