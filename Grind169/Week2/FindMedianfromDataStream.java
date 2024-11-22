class MedianFinder {

    PriorityQueue<Double> top;
    PriorityQueue<Double> bottom;
    public MedianFinder() {
        top = new PriorityQueue<>((a,b) -> Double.compare(a,b));
        bottom = new PriorityQueue<>((a,b) -> Double.compare(b,a));
    }
    
    public void addNum(int num) {
        top.offer((double)num);
        bottom.offer(top.poll());
        if(top.size() + 1 < bottom.size()){
            top.offer(bottom.poll());
        }
    }
    
    public double findMedian() {
        int size = top.size() + bottom.size();
        double result = 0;
        if(size % 2 == 0){
            result = (top.peek() + bottom.peek())/2;
        }
        else{
            result = bottom.peek();
        }
        return result;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */