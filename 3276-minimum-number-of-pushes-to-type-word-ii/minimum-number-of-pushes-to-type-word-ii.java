class Solution {

    public int minimumPushes(String word) {
        // Frequency map to store count of each letter
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of each letter
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Priority queue to store frequencies in descending order
        PriorityQueue<Integer> frequencyQueue = new PriorityQueue<>(
            (a, b) -> b - a
        );
        frequencyQueue.addAll(frequencyMap.values());

        int totalPushes = 0;
        int index = 0;

        // Calculate total number of presses
        while (!frequencyQueue.isEmpty()) {
            totalPushes += (index / 8 + 1) * frequencyQueue.poll();
            index++;
        }

        return totalPushes;
    }
}