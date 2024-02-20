class Solution {
    //Using hashset 30% beats
    // public int findDuplicate(int[] nums) {
    //     HashSet<Integer> set=new HashSet<>();
    //     for(int num:nums){
    //         if(set.contains(num)) return num;
    //         set.add(num);
    //     }
    //     return -1;
    // }

    //Using a count array to store count- 98% beats
    // public int findDuplicate(int[] nums) {
    //     int n=nums.length;
    //     int count[]=new int[n];

    //     for(int num:nums){
    //         if(count[num]!=0) return num;
    //         count[num]++;
    //     }
    //     return -1;
    // }

    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }

        return slow;
    }
}