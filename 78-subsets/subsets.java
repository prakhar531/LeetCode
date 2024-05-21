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

// class Solution {
//     List<List<Integer>> ans=new ArrayList<>();
//     public List<List<Integer>> subsets(int[] nums) {
//         Arrays.sort(nums);
//         solve(nums,new ArrayList<>(),0);
//         return ans;
//     }
//     public void solve(int[] nums, ArrayList list, int i){
//         if(i==nums.length){
//             ans.add(new ArrayList<>(list));
//             return;
//         }
//         solve(nums,list,i+1);
//         list.add(nums[i]);
//         solve(nums,list,i+1);
//         list.remove(list.size()-1);
//     }

// }

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if(nums==null || nums.length==0) return result;
        
        subsets(nums,new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void subsets(int[] nums, ArrayList<Integer> temp, int index) {
        // base condition
        if(index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // main logic
		// case 1 : we pick the element
        temp.add(nums[index]);
        subsets(nums, temp, index+1); // move ahead
        temp.remove(temp.size()-1);
        
		// case 2 : we don't pick the element ( notice, we did not add the current element in our temporary list
        subsets(nums, temp, index+1); // move ahead
    }
}