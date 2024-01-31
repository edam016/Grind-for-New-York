class KthLargest {
    PriorityQueue<Integer> q;
    int index;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>((a,b) -> (Integer.compare(a,b)));
        index = k;
        for(int val : nums){
            q.offer(val);
            if(q.size() > k){
                q.remove();
            }
        }
    }
    
    public int add(int val) {
        q.offer(val);
        while(q.size() > index){
            q.remove();
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */