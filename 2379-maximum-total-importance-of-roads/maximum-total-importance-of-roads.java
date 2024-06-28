class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] count=new long[n];
        for(int[] arr:roads){
            count[arr[0]]++;
            count[arr[1]]++;
        }
        Arrays.sort(count);
        long ans=0;
        long temp=n;
        for(int i=n-1;i>=0;i--){
            if(temp>0){
                ans+=count[i]*temp;
                temp--;
            }
        }
        return ans;
    }
}