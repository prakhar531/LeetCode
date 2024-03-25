class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int count[]=new int[nums.length+1];
        for(int num:nums){
            count[num]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<nums.length+1;i++){
            if(count[i]>1) ans.add(i);
        }
        return ans;
    }
}