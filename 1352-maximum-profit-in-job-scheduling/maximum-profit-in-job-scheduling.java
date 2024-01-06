class Solution {
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int[] dp = new int[jobs.length];
        dp[jobs.length - 1] = jobs[jobs.length - 1][2];
        for (int cur = jobs.length - 2; cur >= 0; cur--) {
            int next = findNext(cur, jobs);
            dp[cur] = Math.max(
                jobs[cur][2] + (next == -1 ? 0 : dp[next]),
                dp[cur + 1]
            );
        }
        return dp[0];
    }
    
    private int findNext(int cur, int[][] jobs) {
        for (int next = cur + 1; next < jobs.length; next++) {
            if (jobs[next][0] >= jobs[cur][1]) {
                return next;   
            }
        }
        return -1;
    }
}