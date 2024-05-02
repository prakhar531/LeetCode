class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int temp:nums){
            set.add(temp);
        }
        int ans=Integer.MIN_VALUE;
        for(int temp:set){
            if(temp>0)
            {
                if(set.contains(temp-2*temp)) ans=Math.max(temp,ans);
            }
        }
        return ans==Integer.MIN_VALUE?-1:ans;
        
    }
}