class MinStack {

    class Data{
        int val;
        int min;

        public Data(int val, int min){
            this.val = val;
            this.min = min;
        }
    }


    Stack<Data> sk;
    public MinStack() {
        sk = new Stack();
    }
    
    public void push(int val) {
        int newMin = val;
        if(!sk.isEmpty()){
            newMin = Math.min(val, sk.peek().min);
        }
        sk.push(new Data(val, newMin));
    }
    
    public void pop() {
        sk.pop();
    }
    
    public int top() {
        return sk.peek().val;
    }
    
    public int getMin() {
        return sk.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */