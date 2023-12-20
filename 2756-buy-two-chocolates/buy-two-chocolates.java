class Solution {
    public int buyChoco(int[] prices, int money) {
        if(prices.length<2) return money;
        int firstMin=Integer.MAX_VALUE;
        int secondMin=firstMin;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<firstMin){
                secondMin=firstMin;
                firstMin=prices[i];
            }else if(prices[i]<secondMin){
                secondMin=prices[i];
            }
        }
        if(firstMin+secondMin>money) return money;

        return money-(firstMin+secondMin);
        
    }
}