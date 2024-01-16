class Solution {
    class Position{
        int x;
        int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }
        int count = 0, rotten = 0, time = 0;
        Queue<Position> q = new LinkedList();
        for(int i = 0;i<=grid.length-1;i++){
            for(int j = 0;j<=grid[0].length-1;j++){
                if(grid[i][j] == 1 || grid[i][j] == 2){
                    count++;
                }
                if(grid[i][j] == 2){
                    q.offer(new Position(i, j));
                }
            }
        }
        if(count == 0 && q.size() == 0){
            return 0;
        }
        if(count == 0){
            return -1;
        }
        while(!q.isEmpty()){
            int size = q.size();
            rotten += size;
            if(rotten == count){
                return time;
            }
            time++;
            for(int i = 0;i<size;i++){
                Position pos = q.poll();
                if(pos.x + 1 < grid.length && grid[pos.x+1][pos.y] == 1){
                    grid[pos.x+1][pos.y] = 2;
                    q.offer(new Position(pos.x+1, pos.y));
                }
                if(pos.x - 1 >= 0 && grid[pos.x - 1][pos.y] == 1){
                    grid[pos.x - 1][pos.y] = 2;
                    q.offer(new Position(pos.x - 1, pos.y));
                }
                if(pos.y + 1 < grid[0].length && grid[pos.x][pos.y + 1] == 1){
                    grid[pos.x][pos.y + 1] = 2;
                    q.offer(new Position(pos.x, pos.y+1));
                }
                if(pos.y - 1 >= 0 && grid[pos.x][pos.y - 1] == 1){
                    grid[pos.x][pos.y - 1] = 2;
                    q.offer(new Position(pos.x, pos.y - 1));
                }
            }
        }
        return -1;
    }
}