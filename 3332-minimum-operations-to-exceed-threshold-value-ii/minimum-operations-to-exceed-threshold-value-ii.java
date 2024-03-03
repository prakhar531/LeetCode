class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int num:nums) pq.add((long)num);

        int ans=0;
        while(pq.size()>1){
            long low=pq.remove();
            long high=pq.remove();

            if(low<k || high<k){
                ans++;
                pq.add((low*2)+high);
            }else{
                return ans;
            }
        }
        return ans;
    }
}