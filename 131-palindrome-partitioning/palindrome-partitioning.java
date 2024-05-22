class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> list=new ArrayList<>();
        solve(0,s,list);
        return ans;
    }
    public void solve(int idx,String s,List<String> list){
        if(idx==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(check(s,idx,i)){
                list.add(s.substring(idx,i+1));
                solve(i+1,s,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean check(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}