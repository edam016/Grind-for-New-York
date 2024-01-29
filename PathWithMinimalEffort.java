class Solution {

    class Position {
        int x;
        int y;
        int diff;

        public Position(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }

    //use a visited array

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Integer> res = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        PriorityQueue<Position> q = new PriorityQueue<>((a, b) -> Integer.compare(a.diff, b.diff));
        
        q.offer(new Position(0, 0, 0));

        int[][] visited = new int[heights.length][heights[0].length];

        for(int i = 0;i<visited.length;i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Position pos = q.poll();  
                if (pos.x == heights.length - 1 && pos.y == heights[0].length - 1) {
                    System.out.println(pos.diff);
                    res.offer(pos.diff);
                }
                if(pos.x + 1 < heights.length){
                    int val = Math.max(pos.diff, Math.abs(heights[pos.x+1][pos.y] - heights[pos.x][pos.y]));
                    if(val < visited[pos.x + 1][pos.y]){
                        visited[pos.x + 1][pos.y] = val;
                        q.offer(new Position(pos.x + 1,pos.y, val));
                    }
                }
                if(pos.x - 1 >= 0){
                    int val = Math.max(pos.diff, Math.abs(heights[pos.x-1][pos.y] - heights[pos.x][pos.y]));
                    if(val < visited[pos.x - 1][pos.y]){
                        visited[pos.x - 1][pos.y] = val;
                        q.offer(new Position(pos.x - 1,pos.y, val));
                    }
                }
                if(pos.y + 1 < heights[0].length){
                    int val = Math.max(pos.diff, Math.abs(heights[pos.x][pos.y + 1] - heights[pos.x][pos.y]));
                    if(val < visited[pos.x][pos.y + 1]){
                        visited[pos.x][pos.y + 1] = val;
                        q.offer(new Position(pos.x,pos.y + 1, val));
                    }
                }
                if(pos.y - 1 >= 0){
                    int val = Math.max(pos.diff, Math.abs(heights[pos.x][pos.y - 1] - heights[pos.x][pos.y]));
                    if(val < visited[pos.x][pos.y - 1]){
                        visited[pos.x][pos.y - 1] = val;
                        q.offer(new Position(pos.x,pos.y - 1, val));
                    }
                }
            }
        }

        return res.poll();
    }
}