class Solution {
    int ans=0;
    public boolean isUnique(String str){
        int arr[]=new int[26];
        for(char ch:str.toCharArray()){
            arr[ch-'a']++;
        }
        for(int it:arr) {
            if(it>1) return false;
        }
        return true;
    }
    public void solve(List<String> arr, String str, int idx){
        if(idx==arr.size()) return;
        if(isUnique(str+arr.get(idx))){
            ans=Math.max(ans,str.length()+arr.get(idx).length());
            solve(arr,str+arr.get(idx),idx+1);
        } 
        solve(arr,str,idx+1);

    }
    public int maxLength(List<String> arr) {
        solve(arr,"",0);
        return ans;
    }
}