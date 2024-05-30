class Solution {
    public int countTriplets(int[] arr) {
        int prefix[]=new int[arr.length+1];
        prefix[0]=0;
        for(int i=0;i<arr.length;i++){
            prefix[i+1]=prefix[i]^arr[i];
        }
        int ans=0;
        for(int start=0;start<prefix.length;start++){
            for(int end=start+1;end<prefix.length;end++){
                if(prefix[start]==prefix[end]){
                    ans+=end-start-1;
                }
            }
        }
        return ans;
    }
}