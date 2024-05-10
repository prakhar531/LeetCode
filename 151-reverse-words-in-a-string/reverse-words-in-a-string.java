// class Solution {
//     public String reverseWords(String s) {
//         String[] arr=s.split("\\s+");
//         StringBuilder sb=new StringBuilder("");
//         int n=arr.length;
//         for(int i=n-1;i>=0;i--){
//             sb.append(arr[i]);
//             sb.append(" ");
//         }
//         return sb.toString().trim();
//     }
// }

class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        char[] res = new char[s.length() + 1];
        int i = s.length() - 1;
        int j;
        int k = 0;
         while(i >= 0) {
            while(i >= 0 && str[i] == ' ') {
                i--;
            }

            if(i < 0) break;
            j = i;
            while(i >= 0 && str[i]!=' ') {
                i--;
            }
            for(int l = i+1;l <= j;l++) {
                res[k++] = str[l];
            }
            res[k++] = ' ';
        }
        return new String(res, 0, k - 1);
    }
}