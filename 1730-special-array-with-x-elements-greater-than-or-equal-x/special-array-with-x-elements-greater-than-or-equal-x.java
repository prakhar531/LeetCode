class Solution {
    public int specialArray(int[] nums) {
        int max=0;
        for(int num:nums){
            max=Math.max(num,max);
        }
        if(max==0 && nums.length>1) return -1;
        int arr[]=new int[max+1];
        for(int num:nums){
            arr[num]++;
        }
        for(int i=max-1;i>=0;i--){
            arr[i]+=arr[i+1];
        }
        int j=0;
        while(j<=nums.length && j<=max){
            if(arr[j]==j) return j;
            j++;
        }
        return -1;
    }
}