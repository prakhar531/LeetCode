class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n=candies.length;
        int left[]=new int[n];
        int right[]=new int[n];

        left[0]=candies[0];
        right[n-1]=candies[n-1];

        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],candies[i]);
        }
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],candies[i]);
        }

        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int curr=candies[i]+extraCandies;
            if(curr>=left[i]&&curr>=right[i]){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
        
    }
}