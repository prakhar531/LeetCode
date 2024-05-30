// class Solution {
//     public int countTriplets(int[] arr) {
//         int prefix[]=new int[arr.length+1];
//         prefix[0]=0;
//         for(int i=0;i<arr.length;i++){
//             prefix[i+1]=prefix[i]^arr[i];
//         }
//         int ans=0;
//         for(int start=0;start<prefix.length;start++){
//             for(int end=start+1;end<prefix.length;end++){
//                 if(prefix[start]==prefix[end]){
//                     ans+=end-start-1;
//                 }
//             }
//         }
//         return ans;
//     }
// }

class Solution {

    public int countTriplets(int[] arr) {
        int size = arr.length;
        int count = 0;
        int prefix = 0;

        // Maps to store counts and totals of XOR values encountered
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        Map<Integer, Integer> totalMap = new HashMap<>();

        // Iterating through the array
        for (int i = 0; i < size; ++i) {
            // Calculating XOR prefix
            prefix ^= arr[i];

            // Calculating contribution of current element to the result
            count +=
            countMap.getOrDefault(prefix, 0) * i -
            totalMap.getOrDefault(prefix, 0);

            // Updating total count of current XOR value
            totalMap.put(prefix, totalMap.getOrDefault(prefix, 0) + i + 1);
            countMap.put(prefix, countMap.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}