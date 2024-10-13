class MinStack {
    PriorityQueue<Integer> pq;
    List<Integer> arr;
    public MinStack() {
        pq = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        arr = new ArrayList();
    }
    
    public void push(int val) {
        pq.offer(val);
        arr.add(0, val);
    }
    
    public void pop() {
        pq.remove(arr.get(0));
        arr.remove(0);
    }
    
    public int top() {
        return arr.get(0);
    }
    
    public int getMin() {
        return pq.peek();
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