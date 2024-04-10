class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[0] * b[0] + b[1] * b[1],a[0] * a[0] + a[1] * a[1]));
        int[][] result = new int[k][2];
        for(int[] val : points){
            int[] values = new int[2];
            values[0] = val[0];
            values[1] = val[1];
            q.offer(values);
            if(q.size() > k){
                q.remove();
            }
        }
        int i = 0;
        for(int[] res : q){
            result[i] = res;
            i++;
        }
        return result;
    }
}