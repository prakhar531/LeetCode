// class Solution {
//     List<List<String>> ans=new ArrayList<>();
//     public List<List<String>> partition(String s) {
//         List<String> list=new ArrayList<>();
//         solve(0,s,list);
//         return ans;
//     }
//     public void solve(int idx,String s,List<String> list){
//         if(idx==s.length()){
//             ans.add(new ArrayList<>(list));
//             return;
//         }
//         for(int i=idx;i<s.length();i++){
//             if(check(s,idx,i)){
//                 list.add(s.substring(idx,i+1));
//                 solve(i+1,s,list);
//                 list.remove(list.size()-1);
//             }
//         }
//     }
//     public boolean check(String s,int i,int j){
//         while(i<=j){
//             if(s.charAt(i++)!=s.charAt(j--)) return false;
//         }
//         return true;
//     }
// }

import java.util.AbstractList; 

class Solution {

    private StringBuilder givenStr;
    private int givenStrLength;

    private List<List<String>> result;
    private List<String> subsResult;

    public List<List<String>> partition(String s) {

        // result = new ArrayList<List<String>>();
        givenStr = new StringBuilder(s);
        givenStrLength = s.length();
        subsResult = new ArrayList<String>();

        // dfs(0);
        // return result;     

        return new AbstractList<List<String>>() {
            @Override
            public int size() {
                init();
                return result.size();
            }

            @Override
            public List<String> get(int index) {
                init();
                return result.get(index);
            }

            private void init() {
                if (result != null) return;
                result = new ArrayList<List<String>>();
                dfs(0);
            }
        };
        
    }

     private void dfs(int startIndex) {
        if (startIndex == givenStrLength) {
            result.add(new ArrayList<String>(subsResult));
            return;
        }

        for (int i = startIndex; i < givenStrLength; i++) {
            // we do not need to process further
            // if the first part of the string (startIndex to i) is not palindrome
            if (!isPalindrome(givenStr, startIndex, i)) continue;

            // It means that first part (startIndex to i) is palindrome.
            // Let add into the subResult
            subsResult.add(givenStr.substring(startIndex, i + 1));

            // Now let process the second part (i+1 to string length)
            dfs(i + 1);

            // Repeat the for (startIndex to i+1), so let remove from the list
            subsResult.remove(subsResult.size() - 1);
        }

    }

    private boolean isPalindrome(StringBuilder s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

}