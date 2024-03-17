class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {   
    //     ArrayList<int[]> ans=new ArrayList<>();
    //     int idx=0;
    //     while(idx<intervals.length){
    //         if(intervals[idx][0]<newInterval[0]){
    //             ans.add(intervals[idx]);
    //             idx++;
    //         }else{
    //             break;
    //         }
    //     }

    //     if(ans.size()==0 || ans.get(ans.size()-1)[1]<newInterval[0]){
    //         ans.add(newInterval);
    //     }else{
    //         ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],newInterval[1]);
    //     }

    //     while(idx<intervals.length){
    //         int[] curr=ans.get(ans.size()-1);
    //         if(curr[1]>=intervals[idx][0]){
    //             curr[1]=Math.max(curr[1],intervals[idx][1]);
    //         }else{
    //             ans.add(intervals[idx]);
    //         }
    //         idx++;
    //     }

    //     return ans.toArray(new int[ans.size()][]);
    

        ArrayList<int[]> ans=new ArrayList<>();
        int idx=0;
        while(idx<intervals.length){
            if(newInterval[0]>intervals[idx][1]){
                ans.add(intervals[idx]);
                idx++;
            }else{
                break;
            }
        }

        while(idx<intervals.length && newInterval[1]>=intervals[idx][0]){
            newInterval[0]=Math.min(newInterval[0],intervals[idx][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[idx][1]);
            idx++;
        }
        ans.add(newInterval);

        while(idx<intervals.length){
            ans.add(intervals[idx]);
            idx++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}