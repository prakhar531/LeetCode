class Solution {
    Set<Character> set=new HashSet<>();
    public void inti(){
        char ch[]={'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char c: ch) set.add(c);
    }
    public int count(String s){
        int c=0;
        for(char ch:s.toCharArray()){
            if(set.contains(ch)) c++;
        }
        return c;
    }
    public boolean halvesAreAlike(String s) {
        String a=s.substring(0,s.length()/2);
        String b=s.substring(s.length()/2);
        inti();
        int acount=count(a);
        int bcount=count(b);
        return acount==bcount;
    }
}