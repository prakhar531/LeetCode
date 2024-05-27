// class Solution {
//     public int specialArray(int[] nums) {
//         int max=0;
//         for(int num:nums){
//             max=Math.max(num,max);
//         }
//         if(max==0 && nums.length>0) return -1;
//         int arr[]=new int[max+1];
//         for(int num:nums){
//             arr[num]++;
//         }
//         for(int i=max-1;i>=0;i--){
//             arr[i]+=arr[i+1];
//         }
//         int j=0;
//         while(j<=nums.length && j<=max){
//             if(arr[j]==j) return j;
//             j++;
//         }
//         return -1;
//     }
// }

class Solution {
    public int specialArray(int[] nums) {
        int[] numCounts = new int[nums.length+1];
        for(int num: nums)
            if(num>nums.length)
                numCounts[nums.length]++;
            else
                numCounts[num]++;
        int bigNumsCount = 0;
        for(int specialGuess = nums.length; specialGuess>0; specialGuess--){
            bigNumsCount += numCounts[specialGuess];
            if(bigNumsCount > specialGuess)
                return -1;
            if(bigNumsCount == specialGuess)
                return specialGuess;
        }
        return -1;
    }
}