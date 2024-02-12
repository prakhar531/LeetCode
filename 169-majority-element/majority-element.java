class Solution {
    public int majorityElement(int[] nums) {
        // if(nums.length==1){
        //     return nums[0];
        // }
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length-1;i++){
        //     int count=1;
        //     while(i<nums.length-1&&nums[i]==nums[i+1]){
        //         count++;
        //         i++;
        //     }
        //     if(count>nums.length/2){
        //         return nums[i];
        //     }
        // }
        // return -1;
        
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }
        // for(Integer key: map.keySet()){
        //     if(map.get(key)>nums.length/2 ){
        //         return key;
        //     }
        // }
        // return -1;

        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
}