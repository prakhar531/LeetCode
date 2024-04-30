class Solution {
    public long wonderfulSubstrings(String word) {
        int[] count = new int[1024]; // 2^10 to store bitmask frequencies
        count[0] = 1;
        long result = 0;
        int bitmask = 0;

        for (char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            bitmask ^= 1 << charIndex;
            result += count[bitmask];
            for (int i = 0; i < 10; i++) {
                result += count[bitmask ^ (1 << i)];
            }
            count[bitmask]++;
        }

        return result;
    }
}