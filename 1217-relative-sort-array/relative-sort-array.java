class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt=new int[1001];
        for(int i:arr1){
            cnt[i]++;
        }
        int[] ans=new int[arr1.length];
        int i=0;
        for(int n:arr2){
            while(cnt[n]>0){
                ans[i]=n;
                cnt[n]--;
                i++;
            }
        }
        for(int j=0;j<cnt.length;j++){
            while(cnt[j]>0){
                ans[i]=j;
                cnt[j]--;
                i++;
            }
        }
        return ans;
    }
}