class Solution {
    class Data{
        long val;
        int index;
        public Data(long val, int index){
            this.val = val;
            this.index = index;
        }
    }
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList();
        long sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        for(int i = 0;i<nums.length;i++){
            while(!dq.isEmpty() && sum - dq.peekFirst().val >= k){
                minLength = Math.min(minLength, i - dq.peekFirst().index + 1);
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.peekLast().val >= sum){
                dq.pollLast(); //resets this as if the sum is less, then the smallest length mus tbe after the negative so removes all the values before that
            }
            dq.offer(new Data(sum, i));
        }
        return minLength;
    }
}