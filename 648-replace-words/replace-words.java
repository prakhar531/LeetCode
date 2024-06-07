// class Solution {
//     public String replaceWords(List<String> dictionary, String sentence) {
//         HashSet<String> set=new HashSet<>();
//         for(String s: dictionary){
//             set.add(s);
//         }

//         String[] st=sentence.split(" ");
//         StringBuilder sb=new StringBuilder(""); 

//         for(String str:st){
//             StringBuilder curr=new StringBuilder("");
//             int i=0;
//             for(;i<str.length();i++){
//                 curr.append(str.charAt(i));
//                 if(set.contains(curr.toString())){
//                     sb.append(curr.toString());
//                     break;
//                 }
//             }
//             if(i==str.length()) sb.append(str);
//             sb.append(" ");
//         }
//         sb.deleteCharAt(sb.length()-1);
//         return sb.toString();
        
//     }
// }

// class Solution {
//     static class Node {
//         boolean isWord;
//         Node[] children = new Node[26];
//     }

//     Node root = new Node();
//     public String replaceWords(List<String> dictionary, String sentence) {
//         for (String str: dictionary) {
//             insert(str);
//         }
        
//         String[] arr = sentence.split(" ");
//         StringBuilder builder = new StringBuilder("");
//         for (int i=0; i<arr.length; i++) {
//             String replace = search(arr[i]);
//             if (replace == "") {
//                 builder.append(arr[i]);
//             } else {
//                 builder.append(replace);
//             }
//             builder.append(" ");
//         }
//         return builder.toString().trim();
//     }

//     public void insert(String str) {
//         Node node = this.root;
//         for (char c: str.toCharArray()) {
//             int n = c-'a';
//             if (node.children[n] == null) {
//                 node.children[n] = new Node();
//             }
//             node = node.children[n];
//         }
//         node.isWord = true;
//     }


//     public String search(String str) {
//         Node node = this.root;
//         for (int i=0; i<str.length(); i++) {
//             char c = str.charAt(i);
//             int n = c-'a';
//             if (node.children[n] == null) {
//                 return "";
//             }
//             node = node.children[n];
//             if (node.isWord) return str.substring(0, i+1);
//         }
//         return "";
//     }
// }

class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] wordArray = sentence.split(" ");
        Set<String> dictSet = new HashSet<>(dictionary);

        // Replace each word in sentence with the corresponding shortest root
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = shortestRoot(wordArray[i], dictSet);
        }

        return String.join(" ", wordArray);
    }

    private String shortestRoot(String word, Set<String> dictSet) {
        // Find the shortest root of the word in the dictionary
        for (int i = 1; i <= word.length(); i++) {
            String root = word.substring(0, i);
            if (dictSet.contains(root)) {
                return root;
            }
        }
        // There is not a corresponding root in the dictionary
        return word;
    }
}