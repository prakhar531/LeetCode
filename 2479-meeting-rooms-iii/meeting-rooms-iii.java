class Solution {
    public int mostBooked1(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->(a[0] == b[0] ? a[1]-b[1] : (a[0]-b[0])));
        int rooms[] = new int[n];
        int max = -1, idx = n;
        for(int i=0;i<n;i++){
            pq.add(new int[]{0, i});   
        }
        for(int i=0;i<meetings.length;i++){
            while(!pq.isEmpty() && meetings[i][0]>pq.peek()[0]){
                pq.add(new int[]{meetings[i][0], pq.poll()[1]});
            }
            int arr[] = pq.poll();
            rooms[arr[1]]++;
            if(rooms[arr[1]] > max || (rooms[arr[1]] == max && arr[1] < idx)){
                max = rooms[arr[1]];
                idx = arr[1];
            }
            //System.out.println("max: "+max+" idx: "+idx+" endTime: "+arr[0]);
            arr[0] = Math.max(arr[0], meetings[i][0]) + meetings[i][1] - meetings[i][0];
            pq.add(arr);
        }
        return idx;
    }
    public int mostBooked(int n, int[][] mt) {
        int[] cnt = new int[n];
        long[] t = new long[n];
        Arrays.sort(mt, (a, b)->a[0] - b[0]);
        for(int[] m : mt){
            int st = m[0], ed = m[1];
            boolean f = false;
            long min = Long.MAX_VALUE;
            int idx = -1;
            for(int i = 0; i < n; i++){
                if(t[i] < min){
                    min = t[i];
                    idx = i;
                }
                if(t[i] <= st){
                    t[i] = ed;
                    f = true;
                    cnt[i]++;
                    break;
                }
            }
            if(!f){
                t[idx] += (ed - st);
                cnt[idx]++;
            }
        }
        int max = 0, res = 0;
        for(int i = 0; i < n; i++){
            if(cnt[i] > max){
                max = cnt[i];
                res = i;
            }
        }
        return res;
    }
}