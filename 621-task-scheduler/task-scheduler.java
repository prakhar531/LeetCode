class Solution {
    public int leastInterval(char[] tasks, int n) {
        // int count[]=new int[26];
        // for(char ch:tasks) count[ch-'A']++;
        
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i=0;i<26;i++){
        //     if(count[i]>0) pq.add(count[i]);
        // }

        // int time=0;
        // while (!pq.isEmpty()) {
        //     int cycle = n + 1;
        //     List<Integer> store = new ArrayList<>();
        //     int taskCount = 0;
        //     // Execute tasks in each cycle
        //     while (cycle-- > 0 && !pq.isEmpty()) {
        //         int currentFreq = pq.poll();
        //         if (currentFreq > 1) {
        //             store.add(currentFreq - 1);
        //         }
        //         taskCount++;
        //     }
        //     // Restore updated frequencies to the heap
        //     store.forEach(pq::offer);
        //     // Add time for the completed cycle
        //     time += (pq.isEmpty() ? taskCount : n + 1);
        // }
        // return time;

        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Sort the frequency array in non-decreasing order
        Arrays.sort(freq);
        // Calculate the maximum frequency of any task
        int maxFreq = freq[25] - 1;
        // Calculate the number of idle slots that will be required
        int idleSlots = maxFreq * n;

        // Iterate over the frequency array from the second highest frequency to the lowest frequency
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            // Subtract the minimum of the maximum frequency and the current frequency from the idle slots
            idleSlots -= Math.min(maxFreq, freq[i]);
        }

        // If there are any idle slots left, add them to the total number of tasks
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;


    }
}