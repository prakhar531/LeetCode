class Trie {
    Trie[] ch = new Trie[26];
    int visited = 0;
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int[] ans = new int[words.length];
        int k = 0;
        for (String x: words) {
            Trie t = trie;
            for (int i = 0; i < x.length(); i++) {
                int c = x.charAt(i) - 'a';
                if (t.ch[c] == null) t.ch[c] = new Trie();
                t.ch[c].visited++;
                t = t.ch[c];
            }
        }
        for (String x: words) {
            Trie t = trie; int curr = 0;
            for (int i = 0; i < x.length(); i++) {
                int c = x.charAt(i) - 'a';
                curr += t.ch[c].visited;
                t = t.ch[c];
            }
            ans[k++] = curr;
        }
        return ans;
    }
}