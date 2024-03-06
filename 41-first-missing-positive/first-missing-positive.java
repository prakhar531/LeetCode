// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         int min=Integer.MAX_VALUE;
//         int max=Integer.MIN_VALUE;

//         for(int num:nums){
//             if(num<min) min=num;
//             if(num>max) max=num;
//         }

//         if(min>1) return 1;

//         HashSet<Integer> list=new HashSet<>();
//         for(int num:nums){
//             list.add(num);
//         }
//         int it=1;
//         while(it<max){
//             if(!list.contains(it)) return it;
//             it++;
//         }
//         return max<=0?1:max+1;
//     }
// }

class Solution {
    public int firstMissingPositive(int[] nums) {
   int n=nums.length;
   boolean found[]=new boolean[n+1];
   for(int i=0;i<n;i++){
       if(nums[i]>0 && nums[i]<=n){
           found[nums[i]]=true;
       }
   }
   for(int i=1;i<=n;i++){
       if(!found[i]){
           return i;
       }
   }
   return n+1;
   }
}