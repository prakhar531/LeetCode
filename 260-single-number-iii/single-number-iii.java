class Solution {
    public int[] singleNumber(int[] nums) {
        // HashMap<Integer,Integer> map=new HashMap<>();

        // for(int num:nums){
        //     map.put(num,map.getOrDefault(num,0)+1);
        // }
        // int i=0;
        // int ans[]=new int[2];
        // for(int key:map.keySet()){
        //     if(map.get(key)==1) ans[i++]=key;
        // }
        // return ans;

        int xor=0;
        for(int num:nums){
            xor^=num;
        }
        int lastSetBit=xor & (-xor);
        int ans[]=new int[2];
        for(int num:nums){
            if((lastSetBit & num)==0) ans[0]^=num;
            else ans[1]^=num;
        }
        return ans;
        
    }
}