// class Trie {
//     Trie[] ch = new Trie[26];
//     int visited = 0;
// }
// class Solution {
//     public int[] sumPrefixScores(String[] words) {
//         Trie trie = new Trie();
//         int[] ans = new int[words.length];
//         int k = 0;
//         for (String x: words) {
//             Trie t = trie;
//             for (int i = 0; i < x.length(); i++) {
//                 int c = x.charAt(i) - 'a';
//                 if (t.ch[c] == null) t.ch[c] = new Trie();
//                 t.ch[c].visited++;
//                 t = t.ch[c];
//             }
//         }
//         for (String x: words) {
//             Trie t = trie; int curr = 0;
//             for (int i = 0; i < x.length(); i++) {
//                 int c = x.charAt(i) - 'a';
//                 curr += t.ch[c].visited;
//                 t = t.ch[c];
//             }
//             ans[k++] = curr;
//         }
//         return ans;
//     }
// }

class Solution {
    public int[] sumPrefixScores(String[] words) {
        int wordCount = words.length;
        Integer[] sortedIndices = new Integer[wordCount];
        for (int i = 0; i < wordCount; i++) {
            sortedIndices[i] = i;
        }
        Arrays.sort(sortedIndices, (a, b) -> words[a].compareTo(words[b]));
        
        int[] commonPrefixLengths = calculateCommonPrefixLengths(words, sortedIndices);
        int[] scores = calculateScores(words, sortedIndices, commonPrefixLengths);
        return scores;
    }

    private int[] calculateCommonPrefixLengths(String[] words, Integer[] sortedIndices) {
        int[] commonPrefixLengths = new int[words.length];
        for (int i = 1; i < words.length; i++) {
            String prevWord = words[sortedIndices[i - 1]];
            String currWord = words[sortedIndices[i]];
            int commonLength = 0;
            while (commonLength < prevWord.length() && 
                   commonLength < currWord.length() && 
                   prevWord.charAt(commonLength) == currWord.charAt(commonLength)) {
                commonLength++;
            }
            commonPrefixLengths[i] = commonLength;
        }
        return commonPrefixLengths;
    }

    private int[] calculateScores(String[] words, Integer[] sortedIndices, int[] commonPrefixLengths) {
        int[] scores = new int[words.length];
        for (int i = 0; i < sortedIndices.length; i++) {
            int wordIndex = sortedIndices[i];
            int wordLength = words[wordIndex].length();
            scores[wordIndex] += wordLength;
            int j = i + 1;
            int commonLength = wordLength;
            while (j < words.length) {
                commonLength = Math.min(commonLength, commonPrefixLengths[j]);
                if (commonLength == 0) {
                    break;
                }
                scores[wordIndex] += commonLength;
                scores[sortedIndices[j]] += commonLength;
                j++;
            }
        }
        return scores;
    }
}
//Kds Appraoch 1