class Solution {
    class Solve implements Comparable<Solve> {
        int num;
        int count;
        public Solve(int num, int count){
            this.num=num;
            this.count=count;
        }
        @Override
        public int compareTo(Solve s2){
            return this.count-s2.count;
        }
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Solve> pq=new PriorityQueue<>();

        for(int num:arr) map.put(num, map.getOrDefault(num,0)+1);
        for(int key:map.keySet()){
            pq.add(new Solve(key,map.get(key)));
        }

        while(k>0){
            Solve curr=pq.poll();
            if(curr.count==k) break;
            if(curr.count>1){
                curr.count--;
                pq.add(curr);
            }
            k--;
        }
        return pq.size();
    }
}