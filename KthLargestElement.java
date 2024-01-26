class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for(int val : nums){
            q.offer(val);
            if(q.size() > k){
                q.remove();
            }
        }
        return q.poll();
    }
}