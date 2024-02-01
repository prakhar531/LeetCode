// class Solution {
//     public int[][] divideArray(int[] nums, int k) {
//         Arrays.sort(nums);
//         int row=nums.length/3;
//         int ans[][]=new int[row][3];
//         int idx=0;
//         int empty[][]={};
        
//         for(int i=0;i<nums.length-2;i=i+3){
//             if(nums[i+2]-nums[i]>k) return empty;
//         }
        
//         for(int i=0;i<row;i++){
//             for(int j=0;j<3;j++){
//                 ans[i][j]=nums[idx++];
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        if (nums.length % 3 != 0) {
            return new int[0][0];
        }

        int size = nums.length;

        int max = 0;

        for (int n : nums) {
            max = Math.max(max, n);
        }

        int[] freqs = new int[max + 1];

        for (int n : nums) {
            ++freqs[n];
        }

        int[][] subs = new int[size / 3][3];

        for (int n = 1, r = 0, c = 0; r < subs.length && n <= max;) {
            if (freqs[n] == 0) {
                ++n;
            }
            else if (c == subs[r].length) {
                ++r;
                c = 0;
            }
            else if (c == 0 || n - subs[r][0] <= k) {
                subs[r][c] = n;
                --freqs[n];
                ++c;
            }
            else {
                return new int[0][0];
            }
        }

        return subs;
    }
}