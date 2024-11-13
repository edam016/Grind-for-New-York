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

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList();
        int maxVal = mat.length * mat[0].length;        
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
                else{
                    mat[i][j] = maxVal;
                }
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[] dir : directions){
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if(x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && mat[x][y] == maxVal){
                    mat[x][y] = mat[cell[0]][cell[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }//adding previous squares to future total here and using mat[x][y] to keep track of future cells
        }
        return mat;
    }
}