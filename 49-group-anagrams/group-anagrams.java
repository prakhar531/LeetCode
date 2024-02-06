// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String,List<String>> map=new HashMap<>();

//         for(String word: strs){
//             char[] chars=word.toCharArray();
//             Arrays.sort(chars);
//             String sortedWord=new String(chars);

//             if(!map.containsKey(sortedWord)){
//                 map.put(sortedWord,new ArrayList<>());
//             }
//             map.get(sortedWord).add(word);
//         }
//         return new ArrayList<>(map.values());
        
//     }
// }
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            char[] count = new char[26];
            for (int j=0; j<strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                count[c - 'a']++;
            }
            String str = new String(count);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}