class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int i=0;
        int ans[]=new int[2];
        for(int key:map.keySet()){
            if(map.get(key)==1) ans[i++]=key;
        }
        return ans;
    }
}