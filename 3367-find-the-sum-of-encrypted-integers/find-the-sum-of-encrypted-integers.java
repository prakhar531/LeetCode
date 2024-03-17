class Solution {
    public int encrypt(int num){
        int count=0;
        int max=Integer.MIN_VALUE;

        while(num!=0){
            int curr=num%10;
            if(curr>max) max=curr;
            count++;
            num/=10;
        }
        int ans=0;
        while(count!=0){
            count--;
            ans+=Math.pow(10,count)*max;
        }
        return ans;
    }
    public int sumOfEncryptedInt(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=encrypt(nums[i]);
        }
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return sum;
    }
}