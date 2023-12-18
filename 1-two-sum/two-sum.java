class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] ratio=new int[nums.length][2];
        for(int k=0;k<nums.length;k++){
            ratio[k][0]=k;
            ratio[k][1]=nums[k];
        }
        Arrays.sort(ratio,Comparator.comparingInt(o->o[1]));
        int i=0,j=nums.length-1;
        int arr[]=new int[2];
        while(i<j){
            if(ratio[i][1]+ratio[j][1]==target){
                arr[0]=ratio[i][0];
                arr[1]=ratio[j][0];
                break;
            }else if(ratio[i][1]+ratio[j][1]<target){
                i++;
            }else{
                j--;
            }
        }
        return arr;

        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     hm.put(nums[i],i);
        // }
        // int arr[]=new int[2];

        // for(int i=0;i<nums.length;i++){
        //     int ele=target-nums[i];
        //     if(hm.containsKey(ele) && hm.get(ele)!=i){
        //         arr[0]=i;
        //         arr[1]=hm.get(ele);
        //     }
        // }
        // return arr;

    }
}