class StockSpanner {

    Stack<List<Integer>> sk;
    public StockSpanner() {

        sk = new Stack<List<Integer>>();
    }
    
    public int next(int price) {
        List<Integer> arr = new ArrayList<Integer>();
        if(sk.isEmpty()){
            arr.add(price);
            arr.add(1);
            sk.push(arr);
        }
        else if(!sk.isEmpty() && sk.peek().get(0) <= price){
            int total = 0;
            while(!sk.isEmpty() && sk.peek().get(0) <= price){
                total += sk.peek().get(1);
                sk.pop();
            }
            arr.add(price);
            arr.add(total + 1);
            sk.push(arr);
        }
        else{
            arr.add(price);
            arr.add(1);
            sk.push(arr);
        }
        return sk.peek().get(1);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */