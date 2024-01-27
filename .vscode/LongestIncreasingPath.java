class Solution {
    int maxVal;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix == null){
            return 0;
        }
        maxVal = 1;
        int[][] visited = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<visited.length;i++){
            Arrays.fill(visited[i], 0);
        }
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(visited[i][j] == 0){
                    maxVal = Math.max(maxVal, dfs(matrix, visited, i, j, -1));
                }

            }
        }
        return maxVal;
    }

    public int dfs(int[][] matrix, int[][] visited, int x, int y, int prev){
        if(x < 0 || x == matrix.length || y < 0 || y == matrix[0].length || matrix[x][y] <= prev){
            return 0;
        }
        if(visited[x][y] > 0){
            return visited[x][y];
        }
        int value = Math.max(
                        Math.max(dfs(matrix, visited, x + 1, y, matrix[x][y]), dfs(matrix, visited, x - 1, y, matrix[x][y])), 
                        Math.max(dfs(matrix, visited, x, y + 1, matrix[x][y]), dfs(matrix, visited, x, y - 1, matrix[x][y]))
                        );
        visited[x][y] = value + 1;
        return value + 1;
    }
}