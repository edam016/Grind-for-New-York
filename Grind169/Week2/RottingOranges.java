class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList(); 
        int oranges = 0;
        int time = 0;
        int rotted = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1 || grid[i][j] == 2){
                    oranges++;
                }
            }
        }
        int[][] directions = {{1, 0},{0, 1},{-1, 0},{0, -1}};
        while(!q.isEmpty()){
            int size = q.size();
            rotted += q.size();
            if(rotted == oranges){
                return time;
            }
            for(int i = 0;i<size;i++){
                int[] cell = q.poll();
                for(int[] direction : directions){
                    int x = cell[0] + direction[0];
                    int y = cell[1] + direction[1];
                    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
                        continue;
                    }
                    if(grid[x][y] == 1){
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            time++;
        }    
        return rotted == oranges ? time : -1;
    }
}