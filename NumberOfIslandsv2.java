class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    num++;
                    dfs(grid, (int)i, (int)j);
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
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