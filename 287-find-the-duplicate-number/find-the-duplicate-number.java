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

    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int count[]=new int[n];

        for(int num:nums){
            if(count[num]!=0) return num;
            count[num]++;
        }
        return -1;
    }
}