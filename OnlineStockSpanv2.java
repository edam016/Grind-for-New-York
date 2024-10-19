class StockSpanner {
    
    class Data{
        int val;
        int numUnder;

        public Data(int val, int numUnder){
            this.val = val;
            this.numUnder = numUnder;
        }
    }
    Stack<Data> sk;
    public StockSpanner() {
        sk = new Stack();
    }
    
    public int next(int price) {
        int newVal = 1;
        while(!sk.isEmpty() && price >= sk.peek().val){
            newVal += sk.peek().numUnder;
            sk.pop();
        }
        Data data = new Data(price, newVal);
        sk.push(data);
        return newVal;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */