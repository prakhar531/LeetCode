// class Solution {
//     public int getMin(int []temp,int x){
//         for(int i=0;i<50;i++){
//             if(temp[i]>0){
//                 x-=temp[i];
//                 if(x<=0) return i-50;
//             }
//         }
//         return 0;
//     }
//     public int[] getSubarrayBeauty(int[] nums, int k, int x) {
//         int n=nums.length,j=0;
//         int freq[]=new int[101];
//         int ans[]=new int[n-k+1];

//         for(int i=0;i<n;i++){
//             freq[nums[i]+50]++;
//             if(i>=k-1){   
//                 ans[j++]=getMin(freq,x);
//                 freq[nums[i-k+1]+50]--;
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int count=0;
        int arr[]=new int[50+1];
        for(int i=0,j=0;i<n-k+1;i++){
            while(j<=i+k-1){
                if(nums[j]<0){
                    arr[Math.abs(nums[j])]++;
                    count++;
                }
                j++;
            }  
            if(count>=x){
                int pop=0;
                int idx=50;
                int small=0;
                while(pop<x){
                    if(arr[idx]!=0){
                        pop+=arr[idx];
                        small=idx;
                    }
                    idx--;
                }
                ans[i]=(-small);
            }
            
            if(nums[i]<0){
                count--;
                arr[Math.abs(nums[i])]--;
            }
        }
        return ans;
    }
}