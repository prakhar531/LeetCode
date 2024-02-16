// class Solution {
//     // class Solve implements Comparable<Solve> {
//     //     int num;
//     //     int count;
//     //     public Solve(int num, int count){
//     //         this.num=num;
//     //         this.count=count;
//     //     }
//     //     @Override
//     //     public int compareTo(Solve s2){
//     //         return this.count-s2.count;
//     //     }
//     // }
//     // public int findLeastNumOfUniqueInts(int[] arr, int k) {
//     //     HashMap<Integer,Integer> map=new HashMap<>();
//     //     PriorityQueue<Solve> pq=new PriorityQueue<>();

//     //     for(int num:arr) map.put(num, map.getOrDefault(num,0)+1);
//     //     for(int key:map.keySet()){
//     //         pq.add(new Solve(key,map.get(key)));
//     //     }

//     //     while(k>0){
//     //         Solve curr=pq.poll();
//     //         if(curr.count==k) break;
//     //         if(curr.count>1){
//     //             curr.count--;
//     //             pq.add(curr);
//     //         }
//     //         k--;
//     //     }
//     //     return pq.size();
//     // }

//     public int findLeastNumOfUniqueInts(int[] arr, int k) {
//         Map<Integer, Integer> count = new HashMap<>();
//         for (int a : arr)
//             count.put(a, 1 + count.getOrDefault(a, 0));
//         PriorityQueue<Integer> pq = new PriorityQueue<>(count.values());
//         while (k > 0)
//             k -= pq.poll();
//         return k < 0 ? pq.size() + 1 : pq.size();        
//     }
// }

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // List to track all the frequencies
        List<Integer> frequencies = new ArrayList<>(map.values());
        Collections.sort(frequencies);

        int elementsRemoved = 0;

        for (int i = 0; i < frequencies.size(); i++) {
            elementsRemoved += frequencies.get(i);
            if (elementsRemoved > k) {
                return frequencies.size() - i;
            }
        }

        return 0;
    }
}