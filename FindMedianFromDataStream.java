class MedianFinder {
    PriorityQueue<Double> min;
    PriorityQueue<Double> max;
    public MedianFinder() {
        min = new PriorityQueue<>((a,b) -> Double.compare(b,a));
        max = new PriorityQueue<>((a,b) -> Double.compare(a,b));
    }
    
    public void addNum(int num) {
        max.offer((double)num);
        min.offer(max.poll()); // ensures that the value that enters min is the smallest of max
        if(max.size() < min.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if((min.size() + max.size()) % 2 == 0){
            return (min.peek() + max.peek())/2;
        }
        else{
            if(min.size() > max.size()){
                return min.peek();
            }
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */