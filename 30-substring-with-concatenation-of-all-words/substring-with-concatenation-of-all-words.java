// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         Map<String,Integer> map=new HashMap<>();
//         for(String str: words){
//             map.put(str,map.getOrDefault(str,0)+1);
//         }

//         List<Integer> ans=new ArrayList<>();
//         int n=s.length(), num=words.length, len=words[0].length();

//         for(int i=0;i<n-num*len+1;i++){
//             Map<String, Integer> seen=new HashMap<>();
//             int j=0;
//             while(j<num){
//                 String word=s.substring(i+j*len,i+(j+1)*len);
//                 if(map.containsKey(word)){
//                     seen.put(word,seen.getOrDefault(word,0)+1);
//                     if(seen.get(word)>map.getOrDefault(word,0)){
//                         break;
//                     }
//                 }else{
//                     break;
//                 }
//                 j++;
//             }
//             if(j==num) ans.add(i);
//         }
//         return ans;
        
//     }
// }

import java.util.*;

class Solution {
    List<Integer> solvedRes = null;
    String concatString = null;

    public List<Integer> findSubstring(String s, String[] words) {
        return new AbstractList<>() {
            public Integer get(int index) {
                if (solvedRes == null) {
                    solvedRes = solve(s, words);
                }
                return solvedRes.get(index);
            }

            public int size() {
                if (solvedRes == null) {
                    solvedRes = solve(s, words);
                }
                return solvedRes.size();
            }
        };
    }

    List<Integer> solve(String s, String[] words) {
        Map<String, List<Integer>> wordsMap = new HashMap<>();
        int wordLength = words[0].length();
        int n = words.length;
        int totalSize = wordLength * n;
        boolean[] startingLetters = new boolean[26];
        boolean[] endingLetters = new boolean[26];

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            startingLetters[w.charAt(0) - 'a'] = true;
            endingLetters[w.charAt(w.length() - 1) - 'a'] = true;
            wordsMap.computeIfAbsent(w, k -> new ArrayList<>());
            wordsMap.get(w).add(i);
        }

        List<Integer> res = new ArrayList<>();
        //System.out.println(Arrays.toString(startingLetters));
        //System.out.println(Arrays.toString(endingLetters));

        for (int i = 0; i <= s.length() - totalSize; i++) {
            if (startingLetters[s.charAt(i) - 'a']
                    && endingLetters[s.charAt(i + totalSize - 1) - 'a']) {
                boolean contains = consider(i, i + totalSize, s, wordsMap, n);
                if (contains) {
                    res.add(i);
                }
            }
        }

        return res;
    }

    private boolean consider(int from, int to, String s, Map<String, List<Integer>> words, int size) {

        if (words.size() == 1) {
            String value = concat(words);
            return value.equals(s.substring(from, to));
        }
        int len = (to - from) / size;
        boolean[] visited = new boolean[size];

        //System.out.println(from + " " + to + " " + len);
        for (int i = from; i < to; i+= len) {
            String candidate = s.substring(i, i + len);
            if (words.containsKey(candidate)) {
                int unvisitedIndex = getUnvisited(words.get(candidate), visited);
                if (unvisitedIndex >= 0) {
                    visited[unvisitedIndex] = true;
                    continue;
                }
            }

            return false;
        }
        return true;
    }

    private String concat(Map<String, List<Integer>> words) {
        if (concatString != null) {
            return concatString;
        }
        StringBuilder sb = new StringBuilder();
        String key = words.keySet().iterator().next();
        for (Integer values: words.get(key)) {
            sb.append(key);
        }
        concatString = sb.toString();
        return concatString;
    }

    private int getUnvisited(List<Integer> indexList, boolean[] visited) {
        for (int i = 0; i < indexList.size(); i++) {
            if (!visited[indexList.get(i)]) {
                return indexList.get(i);
            }
        }
        return -1;
    }

    record Pair(char start, char end){}
}