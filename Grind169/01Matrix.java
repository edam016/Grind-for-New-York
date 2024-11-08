class Solution {
    
    class Position{
        int x;
        int y;
        int count;

        public Position(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] grid = new int[mat.length][mat[0].length];
        Queue<Position> q = new LinkedList();
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    q.offer(new Position(i, j, 1));
                    
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                Position pos = q.poll();
                if(pos.x - 1 >= 0 && mat[pos.x - 1][pos.y] == 1 && grid[pos.x - 1][pos.y] == 0){
                    grid[pos.x - 1][pos.y] = pos.count;
                    q.offer(new Position(pos.x - 1, pos.y, pos.count + 1));
                }
                if(pos.x + 1 < mat.length && mat[pos.x + 1][pos.y] == 1 && grid[pos.x + 1][pos.y] == 0){
                    grid[pos.x + 1][pos.y] = pos.count;
                    q.offer(new Position(pos.x + 1, pos.y, pos.count + 1));
                }
                if(pos.y - 1 >= 0 && mat[pos.x][pos.y - 1] == 1 && grid[pos.x][pos.y - 1] == 0){
                    grid[pos.x][pos.y - 1] = pos.count;
                    q.offer(new Position(pos.x, pos.y - 1, pos.count + 1));
                }
                if(pos.y + 1 < mat[0].length && mat[pos.x][pos.y + 1] == 1 && grid[pos.x][pos.y + 1] == 0){
                    grid[pos.x][pos.y + 1] = pos.count;
                    q.offer(new Position(pos.x, pos.y + 1, pos.count + 1));
                }
            }
        }
        return grid;
    }
}