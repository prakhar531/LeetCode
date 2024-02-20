// class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         int i=0;
//         for(i=0;i<nums.length;i++){
//             if(nums[i]!=i){
//                 break;
//             }
//         }
//         return i;
        
//     }
// }

class Solution{
    public int missingNumber(int[] nums) {
        int arr[]=new int[nums.length+1];
        int i=0;
        for( i=0;i<nums.length;i++){
            arr[nums[i]]=1;
        }
        for( i=0;i<nums.length+1;i++){
            if(arr[i]==0){
                break;
            }
        }
        return i;
    }
}