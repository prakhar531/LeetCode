class Solution {
    // public List<List<Integer>> ans = new ArrayList<>();

    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     Arrays.sort(candidates);
    //     solve(candidates, target, 0, new ArrayList<>());
    //     return ans;
    // }

    // public void solve(int[] arr, int target, int idx, List<Integer> temp) {
    //     if (target == 0) {
    //         if(!ans.contains(temp)) ans.add(new ArrayList<>(temp));
    //         return;
    //     }

    //     if (target < 0 || idx >= arr.length) {
    //         return;
    //     }
    //     temp.add(arr[idx]);
    //     solve(arr, target - arr[idx], idx+1, temp);
    //     temp.remove(temp.size() - 1);
    //     solve(arr, target, idx + 1, temp);

    // }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
    
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1); 
        }
    }
} 
}