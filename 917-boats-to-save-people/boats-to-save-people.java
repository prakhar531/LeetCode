class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Arrays.sort(people);
        // int i=0,j=people.length-1;
        // int ans=0;
        // while(i<=j){
        //     int sum=i==j?people[i]:people[i]+people[j];
        //     if(sum>limit){
        //         ans++;
        //         j--;
        //     }else{
        //         ans++;
        //         i++;
        //         j--;
        //     }
        // }
        // return ans;

        int arr[]=new int[limit+1];
        for(int wt:people){
            arr[wt]++;
        }
        int i=0,j=limit;
        int ans=0;
        while(i<=j){
            while(i<=j && arr[i]<=0) i++;
            while(i<=j && arr[j]<=0) j--;

            if(arr[i]<=0 && arr[j]<=0) break;
            ans++;
            if(i+j<=limit){
                arr[i]--;
            }
            arr[j]--;
        }
        return ans;
    }
}