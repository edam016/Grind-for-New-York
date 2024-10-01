class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList();
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(!dq.isEmpty() && dq.peek() <= right - k){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast();
            }
            dq.offer(right);
            if(right - left + 1 >= k){
                result[left] = nums[dq.peek()];
                left++;
            }
            right++;
        }
        return result;
    }
}