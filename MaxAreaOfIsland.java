class Solution {
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for(int i = 0;i<=grid.length-1;i++){
            for(int j = 0;j<=grid[0].length-1;j++){
                if(grid[i][j] == 1){
                    result = Math.max(result, dfs(grid, i, j));
                    count = 0;
                }
            }
        }
        return result;
    }

    public int dfs(int[][] grid, int x, int y){
        if(x < 0 || x == grid.length || y < 0 || y == grid[0].length){
            return 0;
        }
        if(grid[x][y] != 1){
            return 0;
        }
        grid[x][y] = -1;
        count++;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        return count;
    }
}