// class Solution {

//     public int minimumPushes(String word) {
//         // Frequency map to store count of each letter
//         Map<Character, Integer> frequencyMap = new HashMap<>();

//         // Count occurrences of each letter
//         for (char c : word.toCharArray()) {
//             frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
//         }

//         // Priority queue to store frequencies in descending order
//         PriorityQueue<Integer> frequencyQueue = new PriorityQueue<>(
//             (a, b) -> b - a
//         );
//         frequencyQueue.addAll(frequencyMap.values());

//         int totalPushes = 0;
//         int index = 0;

//         // Calculate total number of presses
//         while (!frequencyQueue.isEmpty()) {
//             totalPushes += (index / 8 + 1) * frequencyQueue.poll();
//             index++;
//         }

//         return totalPushes;
//     }
// }

class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for(int i=0;i<word.length();i++){
            arr[word.charAt(i) - 'a']++;
        }
        Arrays.sort(arr);
        int i=25;
        int count = 0;
        int start = 1;
        int ans =0;
        while( i >= 0 && arr[i] != 0){
            ans+=(start * arr[i]);
            count++;
            if(count == 8){ 
                start++;
                count = 0;
            }
            i--;
        }
        return ans;
    }
}