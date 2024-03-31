// class Solution {
//     public long countSubarrays(int[] nums, int minK, int maxK) {
//         long res=0;
//         int badIdx=-1, leftIdx=-1, rightIdx=-1;

//         for(int i=0;i<nums.length;i++){
//             if(!(minK<=nums[i] && nums[i]<=maxK)){
//                 badIdx=i;
//             }
//             if(nums[i]==minK){
//                 leftIdx=i;
//             }
//             if(nums[i]==maxK){
//                 rightIdx=i;
//             }
//             res+=Math.max(0,Math.min(leftIdx,rightIdx)-badIdx);
//         }
//         return res;
//     }
// }
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minI = -1, maxI = -1, left = -1, right = 0;
        long count = 0;
        while(right < nums.length){
            if(nums[right] < minK || nums[right] > maxK){
                minI = right;
                maxI = right;
                left = right;
            }
            minI = nums[right] == minK ? right : minI;
            maxI = nums[right] == maxK ?  right : maxI;
            count += Math.min(minI, maxI) - left;
            right++;
        }
        return count;
    }
}