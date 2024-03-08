class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Map<Integer,Integer> map=new HashMap<>();
        // for(Integer num:nums) map.put(num,map.getOrDefault(num,0)+1);
        // int max=0;
        // for(Integer it:map.keySet()){
        //     max=Math.max(map.get(it),max);
        // }
        // int ans=0;
        // for(Integer it:map.keySet()){
        //     if(map.get(it)==max) ans+=max;
        // }
        // return ans;

        int max=-1;
        int freq[]=new int[101];
        for(int it:nums){
            freq[it]++;
            if(max<freq[it]) max=freq[it];
        } 
        int ans=0;
        for(int i=1;i<101;i++){
            if(max==freq[i]){
                ans+=max;
            }
        } 
        return ans;
    }
}