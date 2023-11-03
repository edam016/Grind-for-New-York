class StockSpanner {

    class Pair{
        int price;
        int val;
        Pair(int price, int val){
            this.price = price;
            this.val = val;
        }
    }
    Stack<Pair> sk;
    public StockSpanner() {
        sk = new Stack();
    }
    
    public int next(int price) {
        Pair pair;
        if(sk.isEmpty()){
            pair = new Pair(price, 1);
            sk.push(pair);
        }
        else{
            if(sk.peek().price <= price){
                int total = 0;
                while(!sk.isEmpty() && sk.peek().price <= price){
                    total += sk.peek().val;
                    sk.pop();
                }
                pair = new Pair(price, total + 1);
            }
            else{
                pair = new Pair(price, 1);
            }
            sk.push(pair);
        }
        return pair.val;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */