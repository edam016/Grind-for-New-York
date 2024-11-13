class Solution {
    public int maxProfit(int[] prices) {
        int minStock = Integer.MAX_VALUE;
        int maxProf = 0;
        for(int i = 0;i<prices.length;i++){
            if(prices[i] < minStock){
                minStock = prices[i];
            }
            if(prices[i] - minStock > maxProf){
                maxProf = prices[i] - minStock;
            }
        }
        return maxProf;
    }
}