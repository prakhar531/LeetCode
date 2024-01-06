class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        
        queue.offer(x);
        int ans=0;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int curr=queue.poll();
                
                if(curr==y) return ans;
                
                if(visited.contains(curr)) continue;
                
                visited.add(curr);
                
                queue.offer(curr+1);
                if(curr>1) queue.offer(curr-1);
                
                if(curr%11==0) queue.offer(curr/11);
                if(curr%5==0) queue.offer(curr/5);
            }
            ans++;
        }
        
        return -1;
        
    }
}