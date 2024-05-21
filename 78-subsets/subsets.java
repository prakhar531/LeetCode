// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> ans=new ArrayList<>();
//         Arrays.sort(nums);
//         backtrack(ans,new ArrayList<>(),nums,0);
//         return ans;
//     }
//     public void backtrack(List<List<Integer>> ans,List<Integer> list,int[] nums,int start){
//         ans.add(new ArrayList<>(list));

//         for(int i=start;i<nums.length;i++){
//             list.add(nums[i]);
//             backtrack(ans,list,nums,i+1);
//             list.remove(list.size()-1);
//         }
//     }
// }

class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        solve(nums,new ArrayList<>(),0);
        return ans;
    }
    public void solve(int[] nums, ArrayList list, int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        solve(nums,list,i+1);
        list.add(nums[i]);
        solve(nums,list,i+1);
        list.remove(list.size()-1);
    }

}