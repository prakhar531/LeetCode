class Solution {
    public int[] rearrangeArray(int[] nums) {
        int arr[]=new int[nums.length];
        int p=0;
        int n=1;
        for(int num : nums){
            if(num>0){
                arr[p]=num;
                p+=2;
            }
            if(num<0){
                arr[n]=num;
                n+=2;
            } 
        }
        return arr;
    }
}