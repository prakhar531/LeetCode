// class Solution {
//     public List<List<Integer>> findWinners(int[][] matches) {
//         List<Integer> winner=new ArrayList<>();
//         List<Integer> loser=new ArrayList<>();

//         for(int i=0;i<matches.length;i++){
//             if(!winner.contains(matches[i][0])) winner.add(matches[i][0]);
//         }
//         HashMap<Integer,Integer> map=new HashMap<>();

//         for(int i=0;i<matches.length;i++){
//             map.put(matches[i][1],map.getOrDefault(matches[i][1],0)+1);
//         }
//         for(int it:map.keySet()){
//             if(winner.contains(it)){
//                 int idx=winner.indexOf(it);
//                 winner.remove(idx);
//             }
//             if(map.get(it)==1) loser.add(it);
//         }
//         Collections.sort(winner);
//         Collections.sort(loser);
//         List<List<Integer>> ans=new ArrayList<>();
//         ans.add(winner);
//         ans.add(loser);
//         return ans;
        
//     }
// }

// class Solution {
//     public List<List<Integer>> findWinners(int[][] matches) {
//         HashMap<Integer,Integer> hm=new HashMap<>();
//         int n=matches.length;
//         for(int i=0;i<n;i++){
//             if(hm.containsKey(matches[i][0]))
//                 hm.put(matches[i][0],hm.get(matches[i][0]));
//             else
//                 hm.put(matches[i][0],0);
            
//             if(hm.containsKey(matches[i][1]))
//                 hm.put(matches[i][1],hm.get(matches[i][1])+1);
//             else
//                 hm.put(matches[i][1],1);
//         }

//         List<List<Integer>> list=new ArrayList<>();
//         List<Integer> list1=new ArrayList<>();
//         List<Integer> list2=new ArrayList<>();

//         for(int key:hm.keySet()){
//             if(hm.get(key)==0){
//                 list1.add(key);
//             }
//             if(hm.get(key)==1){
//                 list2.add(key);
//             }
//         }

//         list.add(list1);
//         list.add(list2);
//         Collections.sort(list1);
//         Collections.sort(list2);
//         return list;
//     }
// }

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] losses = new int[100001];

        for (int i = 0; i < matches.length; i++) {
            int win = matches[i][0];
            int loss = matches[i][1];

            if (losses[win] == 0) {
                losses[win] = -1;
            } 

            if (losses[loss] == -1) {
                losses[loss] = 1;
            } else {
                losses[loss]++;
            }
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < losses.length; i++) {
            if (losses[i] == -1) {
                zeroLoss.add(i);
            } else if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }

        result.add(zeroLoss);
        result.add(oneLoss);

        return result;
    }
}