class Solution {
    public int minimumLevels(int[] possible) {
        int n=possible.length;
        for(int i=0;i<n;i++) if(possible[i]==0) possible[i]=-1;
        int prefix[]=new int[n];

        prefix[0]=possible[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+possible[i];
        }
        for(int i=0;i<n-1;i++){
            if(prefix[n-1]-prefix[i]<prefix[i]){
                return i+1;  
            } 
        }
        return -1;
        
    }
}