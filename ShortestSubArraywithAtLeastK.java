class Solution {

    class Data{
        long sum;
        int index;

        public  Data(long sum, int index){
            this.sum = sum;
            this.index = index;
        }
    }

    public int shortestSubarray(int[] nums, int k) {
        Deque<Data> dq = new LinkedList();
        dq.offer(new Data(0, -1));
        long sum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            while(!dq.isEmpty() && sum - dq.peekFirst().sum >= k){
                minLength = Math.min(minLength, i - dq.peekFirst().index);
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.peekLast().sum >= sum){
                dq.pollLast();
            }
            dq.offer(new Data(sum, i));
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}