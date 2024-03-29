// class Solution {
//     public long countSubarrays(int[] nums, int k) {
//         int max=Integer.MIN_VALUE;
//         for(int num:nums) max=Math.max(num,max);
//         long ans=0;
//         int count=0;

//         for(int left=0,right=0;right<nums.length;right++){
//             if(nums[right]==max) count++;
//             while(count==k){
//                 if(nums[left]==max) count--;
//                 left++;
//             }
//             ans+=left;
//         }
//         return ans;
        
//         // int max=Integer.MIN_VALUE;
//         // for(int num:nums) max=Math.max(num,max);
//         // List<Integer> list=new ArrayList<>();
//         // long ans=0;

//         // for(int i=0;i<nums.length;i++){
//         //     if(nums[i]==max) list.add(i);
//         //     int freq=list.size();
//         //     if(freq>=k){
//         //         ans+=list.get(freq-k)+1;
//         //     }
//         // }
//         // return ans;
//     }
// }

class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = 0, count = 0, n = nums.length;
        for (int num : nums)
            max = Math.max(max, num);
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == max)
                count++;
            while (count >= k) {
                res += n - r;
                if (nums[l] == max)
                    count--;
                l++;
            }
        }
        return res;
    }
}