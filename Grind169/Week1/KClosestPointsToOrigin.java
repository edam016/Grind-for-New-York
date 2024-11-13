class Solution {
    
    class Position{
        int x;
        int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Position> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.x*b.x + b.y*b.y, a.x*a.x + a.y*a.y));
        for(int i = 0;i<points.length;i++){
            pq.offer(new Position(points[i][0], points[i][1]));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] result = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()){
            Position pos = pq.poll();
            result[i][0] = pos.x;
            result[i][1] = pos.y;
            i++;
        }
        return result;
    }
}