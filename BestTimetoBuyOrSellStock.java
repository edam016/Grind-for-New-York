class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowStock = prices[0];
        if(prices.length == 0){
            return 0;
        }
        for(int i=1;i<prices.length;i++){
            if(prices[i]-lowStock > maxProfit){
                maxProfit = prices[i]-lowStock;
            }
            if(prices[i] < lowStock){
                lowStock = prices[i];
            }
        }
        return maxProfit;
    }
    public int maxProfit(int[] prices) {
        int min = 0;
        int profit = Integer.MIN_VALUE;
        int current = prices[0];
        for(int i = 1;i<=prices.length-1;i++){
            profit = Math.max(prices[i] - current, profit);
            current = Math.min(prices[i], current);
        }
        return profit < 0 ? 0 : profit;
    }
}
