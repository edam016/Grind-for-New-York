class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i = 0;i<grid2.length;i++){
            for(int j = 0;j<grid2[i].length;j++){
                if(grid2[i][j] == 1 && grid1[i][j] == 1){
                    if(!dfs(grid1, grid2, i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int x, int y){
        if(x < 0 || x == grid1.length || y < 0 || y == grid1[0].length){
            return false;
        }
        if(grid2[x][y] == 0){
            return false;
        }
        if(grid1[x][y] == 0 && grid2[x][y] == 1){
            return true;
        }
        grid2[x][y] = 0;
        boolean right = dfs(grid1, grid2, x + 1, y);
        boolean left = dfs(grid1, grid2, x - 1, y);
        boolean up = dfs(grid1, grid2, x, y + 1);
        boolean down = dfs(grid1, grid2, x, y - 1);
        return right || left || up || down;
    }
}