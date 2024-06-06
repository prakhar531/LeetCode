class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int it:hand){
            pq.add(it);
        }
        while(pq.size()!=0){
            int last=pq.poll();
            int s=groupSize-1;
            List<Integer> list=new ArrayList<>();
            while(s!=0 && pq.size()!=0){
                int curr=pq.poll();
                if(curr==last){
                    list.add(curr);
                }else if(curr==last+1){
                    last=curr;
                    s--;
                }else{
                    return false;
                }
            }
            while(list.size()!=0) pq.add(list.remove(list.size()-1));
            if(s!=0) return false;
        }
        return true;
    }
}