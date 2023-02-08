public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int stock = prices[0];
        for(int i = 1;i<=prices.length-1;i++){
            if(prices[i] - stock > 0){
                maxProfit += prices[i] - stock;
                stock = prices[i];
        }
        else if(prices[i] < stock){
            stock = prices[i];
        }
    }
        return maxProfit;
    }
} BestTimeToBuyAndSellStock2 {
    
}
