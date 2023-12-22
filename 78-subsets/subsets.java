class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(ans,new ArrayList<>(),nums,0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans,List<Integer> list,int[] nums,int start){
        ans.add(new ArrayList<>(list));

        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(ans,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}