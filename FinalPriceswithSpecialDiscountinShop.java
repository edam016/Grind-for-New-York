class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> sk = new Stack();
        int[] newPrice = new int[prices.length];
        for(int i = prices.length-1;i>=0;i--){
            if(sk.isEmpty()){
                sk.push(prices[i]);
                newPrice[i] = prices[i];
            }
            else if(!sk.isEmpty() && prices[i] < sk.peek()){
                while(!sk.isEmpty() && prices[i] < sk.peek()){
                    sk.pop();
                }
                if(sk.isEmpty()){
                    newPrice[i] = prices[i];
                    sk.push(prices[i]);
                }
                else{
                    newPrice[i] = prices[i] - sk.peek();
                    sk.push(prices[i]);
                }
            }
            else{
                newPrice[i] = prices[i] - sk.peek();
                sk.push(prices[i]);
            }
        }
        return newPrice;
    }
}