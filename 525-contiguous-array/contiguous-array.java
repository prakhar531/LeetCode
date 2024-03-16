class Solution {
    public int findMaxLength(int[] nums) {
        // int preSum[]=new int[nums.length];
        // preSum[0]=nums[0];
        // int ans=0;

        // for(int i=1;i<nums.length;i++) preSum[i]=preSum[i-1]+nums[i];

        // for(int i=1;i<nums.length;i++){
        //     int end=i;
        //     int st=0;
        //     while(st<end){
        //         int len=end-st+1;
        //         int sum= st==0?preSum[end]:preSum[end]-preSum[st-1];
        //         if(sum*2==len) ans=Math.max(ans,len);
        //         st++;
        //     }
        // }
        // return ans;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) nums[i]=-1;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int len=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum)){
                len=Math.max(len,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return len;
    }
}