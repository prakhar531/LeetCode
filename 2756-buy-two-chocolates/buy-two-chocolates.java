class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if(prices.length<2 || prices[0]+prices[1]>money) return money;

        return money-(prices[0]+prices[1]);
        
    }
}