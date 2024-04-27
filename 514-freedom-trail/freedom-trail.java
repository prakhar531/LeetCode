// class Solution {
//     private static final int MAX = Integer.MAX_VALUE;

//     public int findRotateSteps(String ring, String key) {
//         Map<Pair<Integer, Integer>, Integer> bestSteps = new HashMap<>();
//         return tryLock(0, 0, ring, key, MAX, bestSteps);
//     }

//     // Find the minimum steps between two indexes of ring
//     private int countSteps(int curr, int next, int ringLength) {
//         int stepsBetween = Math.abs(curr - next);
//         int stepsAround = ringLength - stepsBetween;
//         return Math.min(stepsBetween, stepsAround);
//     }

//     public int tryLock(int ringIndex, int keyIndex, String ring, String key, int minSteps,
//             Map<Pair<Integer, Integer>, Integer> bestSteps) {
//         // If we have already calculated this sub-problem, return the result
//         if (bestSteps.containsKey(new Pair<>(ringIndex, keyIndex))) {
//             return bestSteps.get(new Pair<>(ringIndex, keyIndex));
//         }
//         // If we reach the end of the key, it has been spelled
//         if (keyIndex == key.length()) {
//             return 0;
//         }
//         // For each occurrence of the character at keyIndex of key in ring
//         // Calculate and save the minimum steps to that character from the ringIndex of ring
//         for (int charIndex = 0; charIndex < ring.length(); charIndex++) {
//             if (ring.charAt(charIndex) == key.charAt(keyIndex)) {
//                 int totalSteps = countSteps(ringIndex, charIndex, ring.length()) + 1
//                                             + tryLock(charIndex, keyIndex + 1, ring, key, MAX, bestSteps);
//                 minSteps = Math.min(minSteps, totalSteps);
//                 bestSteps.put(new Pair<>(ringIndex, keyIndex), minSteps);
//             }
//         }
//         return minSteps;
//     }
// }

class Solution {
    public int findRotateSteps(String ring, String key) {
          char[] r=ring.toCharArray();
        List<Integer>[] p=new List[26];
        for(int i=0;i<r.length;i++) {
            int c=r[i]-'a';
            List<Integer> l=p[c];
            if(l==null) p[c]=l=new ArrayList<>();
            l.add(i);
        }
        return helper(0,0,p,key.toCharArray(),ring,new int[key.length()][r.length]);
    }
    int helper(int in, int pos, List<Integer>[] p, char[] k, String r, int[][] memo) {
        if(in==k.length) return 0;
        if(memo[in][pos]>0) return memo[in][pos]-1;
        int min=Integer.MAX_VALUE;
        for(int i: p[k[in]-'a']) {
            int m;
            if(i>=pos) m=Math.min(i-pos,pos+r.length()-i);
            else m=Math.min(pos-i,i+r.length()-pos);
            min=Math.min(min,m+helper(in+1,i,p,k,r,memo));
        }
        return (memo[in][pos]=min+2)-1;
    }
}