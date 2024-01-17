class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int num:arr) map.put(num,map.getOrDefault(num,0)+1);

        // HashSet<Integer> set=new HashSet<>();
        // for(int num:map.keySet()){
        //     if(!set.contains(map.get(num))){
        //         set.add(map.get(num));
        //     }else{
        //         return false;
        //     }
        // }
        // return true;

        int[] numberOfOccurrences = new int[2001];
        boolean[] used = new boolean[1001];

        for (int i : arr) {
            numberOfOccurrences[1000 + i]++;
        }

        for (int i : arr) {
            int count = numberOfOccurrences[1000 + i];
            numberOfOccurrences[1000 + i] = 0; 
            if (count > 0) {
                if (used[count]) return false;
                else used[count] = true;
            }
        }
        return true;
    }
}