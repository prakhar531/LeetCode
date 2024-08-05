// class Solution {
//     public String kthDistinct(String[] arr, int k) {
//         HashMap<String,Integer> map=new HashMap<>();
//         for(String str:arr){
//             map.put(str,map.getOrDefault(str,0)+1);
//         }
//         int count=0;
//         for(String str:arr){
//             if(map.get(str)==1){
//                 count++;
//                 if(count==k) return str;
//             }
//         }
//         return "";
//     }
// }

class Solution {
    public String kthDistinct(String[] arr, int k) {
        List<String> uniqueValInArray = new LinkedList<>();
        int totalDistinctVal = 0;
        Set<String> nonDistinctSet = new HashSet<>();
        Set<String> distinctSet = new HashSet<>();
        for(String s:arr) {
            if(!nonDistinctSet.contains(s)) {
                if(!distinctSet.contains(s)) {
                    distinctSet.add(s);
                    totalDistinctVal++;
                } else {
                    nonDistinctSet.add(s);
                    distinctSet.remove(s);
                    totalDistinctVal--;
                }
            }
        }
        if(totalDistinctVal<k) {
            return "";
        }
        for(String s:arr) {
            if(distinctSet.contains(s)){
                k--;
                if(k==0){
                    return s;
                }
            }
        }
        return "";
    }
}