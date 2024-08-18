class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        pq.add(1l);
        for(int i=0;i<n-1;i++){
            long val=pq.remove();
            while(!pq.isEmpty() && pq.peek()==val) pq.poll();
            pq.add(val*2);
            pq.add(val*3);
            pq.add(val*5);
        }
        return pq.remove().intValue();    
    }
}