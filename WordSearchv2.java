class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, visited, 0, word, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int[][] visited, int index, String target, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return false;
        }
        
        if(target.charAt(index) != board[x][y] || visited[x][y] == 1){
            return false;
        }

        visited[x][y] = 1;
        index++;

        if(index == target.length()){
            return true;
        }
        boolean found = dfs(board, visited, index, target, x + 1, y) || dfs(board, visited, index, target, x - 1, y) || dfs(board, visited, index, target, x, y + 1) || dfs(board, visited, index, target, x, y - 1);
        visited[x][y] = 0;
        return found;

    }
}