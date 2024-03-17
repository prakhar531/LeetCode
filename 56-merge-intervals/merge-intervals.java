class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1,o2)->o1[0]-o2[0]);
        ArrayList<int[]> ans=new ArrayList<>();

        int start=intervals[0][0];
        int end=intervals[0][1];
        int i=1;

        while(i<intervals.length){
            int s=intervals[i][0];
            int e=intervals[i][1];
            if(s<=end){
                end=Math.max(end,e);
            }else{
                ans.add(new int[]{start,end});
                start=s;
                end=e;
            }
            i++;
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}