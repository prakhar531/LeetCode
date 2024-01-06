class Solution {
    public int count(int x,int y){
        int ans = 0;
        for (int i = 0; i < 32; i++) {

            if (((x >> i) & 1) != ((y >> i) & 1)) {
                ans++;
            }
        }
        return ans;
    }
    public int minOperations(int[] nums, int k) {
        int xor=nums[0];
        for(int i=1;i<nums.length;i++){
            xor^=nums[i];
        }
        if(xor==k) return 0;
        
        return count(k,xor);
           
    }
}