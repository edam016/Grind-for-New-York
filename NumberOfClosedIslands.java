class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length-1;j++){
                if(grid[i][j] == 0){
                   if(dfs(grid, i, j)){
                       count++;
                   }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int x, int y){
        if(x == grid.length || x < 0 || y == grid[0].length || y < 0){
            return false;
        }
        if(grid[x][y] == -1 || grid[x][y] == 1){
            return true;
        }
        grid[x][y] = -1;
        boolean right = dfs(grid, x + 1, y);
        boolean left = dfs(grid, x - 1, y);  
        boolean up = dfs(grid, x, y + 1);
        boolean down = dfs(grid, x, y - 1);

        /**
         * boolean result = dfs(grid, x + 1, y) && dfs(grid, x - 1, y) && dfs(grid, x, y + 1) && dfs(grid, x, y - 1);
        return result;

        Some reason this does not work
         */
        return right && left && up && down;
    }
}