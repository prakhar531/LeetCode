class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {   
        // ArrayList<int[]> ans = new ArrayList<>();
        // int idx = 0;

        // while(idx < intervals.length){
        //     if(intervals[idx][0] < newInterval[0]){
        //         ans.add(intervals[idx]);
        //         idx++;
        //     }else{
        //         break;
        //     }
        // }

        // if(ans.size() == 0 || (newInterval[0] > ans.get(ans.size()-1)[1])){
        //     ans.add(newInterval);
        // }else{
        //     ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1],newInterval[1]);
        // }

        // while(idx < intervals.length){
        //     //reference is getting stored in lastInterval
        //     int[] lastInterval = ans.get(ans.size()-1);
        //     if(lastInterval[1] >= intervals[idx][0]){
        //         lastInterval[1] = Math.max(lastInterval[1], intervals[idx][1]);
        //     }else{
        //         ans.add(intervals[idx]);
        //     }
        //     idx++;
        // }
        // return ans.toArray(new int[ans.size()][]);

        ArrayList<int[]> ans=new ArrayList<>();
        int idx=0;
        while(idx<intervals.length){
            if(intervals[idx][0]<newInterval[0]){
                ans.add(intervals[idx]);
                idx++;
            }else{
                break;
            }
        }

        if(ans.size()==0 || ans.get(ans.size()-1)[1]<newInterval[0]){
            ans.add(newInterval);
        }else{
            ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],newInterval[1]);
        }

        while(idx<intervals.length){
            int[] curr=ans.get(ans.size()-1);
            if(curr[1]>=intervals[idx][0]){
                curr[1]=Math.max(curr[1],intervals[idx][1]);
            }else{
                ans.add(intervals[idx]);
            }
            idx++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}