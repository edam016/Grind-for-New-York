class Solution {
    int result = 0;
    public int numIslands(char[][] grid) {
        for(int i = 0;i<=grid.length-1;i++){
            for(int j = 0;j<=grid[0].length-1;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int x, int y){
        if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0){
            return;
        }
        if(grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}