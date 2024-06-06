class Solution {
    public boolean isPossibleDivide(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        int ks = n / groupSize;
        int[] klen = new int[ks];
        int[] kmax = new int[ks];
        for (int i = 0; i < ks; i++) {
            kmax[i] = -1;
        }
        int top = 0;
        int i = 0;
        while (i < hand.length) {
            int j = top;
            int prev = hand[i];
            while (j < ks && prev == hand[i]) {
                if (kmax[j] != -1 && kmax[j] != hand[i] - 1) {
                    return false;
                }
                kmax[j] = hand[i];
                klen[j]++;
                prev = hand[i];
                if (top == j && klen[j] == groupSize) {
                    top = top + 1;
                }
                i = i + 1;
                j = j + 1;
            }
        }
        return top == ks;
    }
}