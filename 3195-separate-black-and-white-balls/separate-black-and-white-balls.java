class Solution {

    public long minimumSteps(String s) {
        int whitePosition = 0;
        long totalSwaps = 0;

        for (int currentPos = 0; currentPos < s.length(); currentPos++) {
            if (s.charAt(currentPos) == '0') {
                totalSwaps += currentPos - whitePosition;
                whitePosition++;
            }
        }

        return totalSwaps;
    }
}