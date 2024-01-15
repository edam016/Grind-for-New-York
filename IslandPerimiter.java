class Solution {
    public int islandPerimeter(int[][] grid) {
        int perim = 0;
        for(int i = 0;i<=grid.length-1;i++){
            for(int j = 0;j<=grid[0].length-1;j++){
                if(grid[i][j] == 1){
                    perim += dfs(grid, i, j);
                }
            }
        }
        return perim;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i > grid.length-1 || i < 0 || j > grid[0].length-1 || j < 0){
            return 1;
        }
        if(grid[i][j] == -1){
            return 0;
        }
        if(grid[i][j] == 0){
            return 1;
        }
        grid[i][j] = -1;
        int left = dfs(grid, i + 1, j);
        int up = dfs(grid, i - 1, j);
        int down = dfs(grid, i, j + 1);
        int right = dfs(grid, i, j - 1);
        return left + up + down + right;
        
    }
}