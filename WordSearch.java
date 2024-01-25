class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, visited, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int x, int y, int index){
        if(index == word.length()){
            return true;   
        }
        if(x < 0 || x == board.length || y < 0 || y == board[0].length || board[x][y] != word.charAt(index) || visited[x][y]){
            return false;
        }
        visited[x][y] = true;
        boolean result = dfs(board, visited, word, x + 1, y, index + 1) || dfs(board, visited, word, x - 1, y, index + 1) || dfs(board, visited, word, x, y + 1, index + 1) || dfs(board, visited, word, x, y - 1, index + 1);
        visited[x][y] = false;
        return result;
    }
}