class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        int[] result = new int[nums.length];
        for(int val : nums){
            q.offer(val);
        }
        for(int i = 0;i<result.length;i++){
            result[i] = q.poll();
        }
        return result;
    }
}