class Solution {
    public int firstUniqChar(String s) {
        int fre[]=new int[26];
        Queue<Integer> q=new LinkedList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            fre[ch-'a']++;
            q.add(i);
            while(!q.isEmpty()&&fre[s.charAt(q.peek())-'a']>1){
                q.remove();
            }
        }
        return q.isEmpty()?-1:q.peek();
        
    }
}