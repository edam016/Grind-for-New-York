class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0){
            return new int[0];
        }

        int left = 0;
        int right = k-1;
        int[] maxVal = new int[nums.length - k + 1];
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int i = 0;i<k;i++){
            q.offer(nums[i]);
        }

        while(right < nums.length){
            if(right > k - 1){
                q.offer(nums[right]);
            }
            maxVal[left] = q.peek();
            q.remove(nums[left]);
            left++;
            right++;
        }
        return maxVal;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList();

        int right = 0;

        int[] res = new int[nums.length - k + 1];

        while(right < nums.length){
            if(!dq.isEmpty() && dq.peek() < right - k + 1){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast();
            }
            dq.offer(right);
            if(right >= k - 1){
                res[right - k + 1] = nums[dq.peek()];
            }
            right++;
        }
        return res;
    }
}