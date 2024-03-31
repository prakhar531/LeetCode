class Solution {
    public int minimumLevels(int[] possible) {
        // int prefix[]=new int[possible.length];
        // prefix[0]=possible[1]==1?1:-1;
        // for(int i=1;i<possible.length;i++){
        //     prefix[i]=prefix[i-1]+possible[i]==1?1:-1;
        // }
        // int total=0;
        // for(int i=0;i<possible.length;i++){
        //     total+=possible[i]==1?1:-1;
        // }
        // int ans=0;
        // for(int i=0;i<possible.length;i++){
        //     if(total-prefix[i]<prefix[i]){
        //         return i+1;
        //     } 
        // }
        // return -1;

        int n=possible.length;
        for(int i=0;i<n;i++) if(possible[i]==0) possible[i]=-1;
        int prefix[]=new int[n];
        prefix[0]=possible[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+possible[i];
        }
        for(int i=0;i<n;i++){
            if(prefix[n-1]-prefix[i]<prefix[i]){
                if(i!=n-1) return i+1;
                
            } 
        }
        return -1;
        
    }
}