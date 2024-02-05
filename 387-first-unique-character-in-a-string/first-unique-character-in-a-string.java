// class Solution {
//     public int firstUniqChar(String s) {
//         int fre[]=new int[26];
//         Queue<Integer> q=new LinkedList<>();
//         int n=s.length();
//         for(int i=0;i<n;i++){
//             char ch=s.charAt(i);
//             fre[ch-'a']++;
//             q.add(i);
//             while(!q.isEmpty()&&fre[s.charAt(q.peek())-'a']>1){
//                 q.remove();
//             }
//         }
//         return q.isEmpty()?-1:q.peek();
        
//     }
// }

//Method 2
// class Solution {
//     public int firstUniqChar(String s) {
//         int fre[]=new int[26];
//         int n=s.length();
//         for(int i=0;i<n;i++){
//             char ch=s.charAt(i);
//             fre[ch-'a']++;
//         }
//         for(int i=0;i<n;i++){
//             if(fre[s.charAt(i)-'a']==1) return i;
//         }
//         return -1;      
//     }
// }

class Solution {
    public int firstUniqChar(String s) {
        int ans=Integer.MAX_VALUE;

        for(char c='a';c<='z';c++){
            int index=s.indexOf(c);
            if(index!=-1 && index==s.lastIndexOf(c)) ans=Math.min(ans,index);
        }  

        return ans==Integer.MAX_VALUE?-1:ans;    
    }
}