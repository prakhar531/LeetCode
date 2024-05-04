class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0,j=people.length-1;
        int ans=0;
        while(i<=j){
            int sum=i==j?people[i]:people[i]+people[j];
            if(sum>limit){
                ans++;
                j--;
            }else{
                ans++;
                i++;
                j--;
            }
        }
        return ans;
    }
}