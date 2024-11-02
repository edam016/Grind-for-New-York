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

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((b,a) -> Integer.compare(b, a));

        for(int i = 0;i<nums.length;i++){
            pq.offer(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}