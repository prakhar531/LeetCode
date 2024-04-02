// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         if(s1.length()>s2.length()) return false;

//         int s1arr[]=new int[26];
//         int s2arr[]=new int[26];

//         for(int i=0;i<s1.length();i++){
//             s1arr[s1.charAt(i)-'a']++;
//             s2arr[s2.charAt(i)-'a']++;
//         }
//         if(Arrays.equals(s1arr,s2arr)) return true;

//         int k=s1.length();
//         for(int i=k;i<s2.length();i++){
//             s2arr[s2.charAt(i)-'a']++;
//             s2arr[s2.charAt(i-k)-'a']--;
//             if(Arrays.equals(s1arr,s2arr)) return true;
//         }
//         return false;
//     }
// }

class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < n1; i++) {
            map[c1[i] - 'a']++;
        }
        for (int i = 0; i < n1; i++) {
            map[c2[i] - 'a']--;
        }
        int diffLetCount = 0;
        for (int diff : map) {
            if (diff > 0) {
                diffLetCount++;
            }
        }
        if (diffLetCount == 0) {
            return true;
        }
        for (int i = 0, n = n2 - n1; i < n; i++) {
            diffLetCount = getDiffLetCount(map, c2, i, diffLetCount, n1);
            if (diffLetCount == 0) {
                return true;
            }
        }
        return false;
    }

    private static int getDiffLetCount(int[] map, char[] c2, int i, int diffLetCount, int n1) {
        if (++map[c2[i] - 'a'] == 1) {
            diffLetCount++;
        }
        if (--map[c2[i + n1] - 'a'] == 0) {
            diffLetCount--;
        }
        return diffLetCount;
    }

    public boolean checkInclusion1(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] map = new int[26];
        int diffSum = 0;
        for (int i = 0; i < n1; i++) {
            diffSum += ++map[c1[i] - 'a'] - map[c2[i] - 'a']--;
        }
        if (diffSum == 0) {
            return true;
        }
        for (int i = 0, n = n2 - n1; i < n; i++) {
            diffSum += ++map[c2[i] - 'a'] - map[c2[i + n1] - 'a']--;
            if (diffSum == 0) {
                return true;
            }
        }
        return false;
    }

}