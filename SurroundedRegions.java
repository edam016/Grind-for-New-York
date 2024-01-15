class Solution {
    public void solve(char[][] board) {
        for(int i = 0;i<=board.length-1;i++){
            for(int j = 0;j<=board[0].length-1;j++){
                if(board[i][j] == 'O'){
                    if(checkDfs(board, i, j)){
                        changeDfs(board, i, j);
                    }
                    else{
                        revert(board, i, j);
                    }
                }
            }
        }
    }

    public boolean checkDfs(char[][] board, int x, int y){
        if(x < 0 || x == board.length || y < 0 || y == board[0].length){
            return false;
        }
        if(board[x][y] == 'X' || board[x][y] == 'C'){
            return true;
        }
        board[x][y] = 'C';
        return checkDfs(board, x + 1, y) && checkDfs(board, x, y + 1) && checkDfs(board, x - 1, y) && checkDfs(board, x, y - 1);
    }

    public void changeDfs(char[][] board, int x, int y){
        if(x < 0 || x == board.length || y < 0 || y == board[0].length){
            return;
        }
        if(board[x][y] == 'X'){
            return;
        }
        board[x][y] = 'X';
        changeDfs(board, x + 1, y);
        changeDfs(board, x - 1, y);
        changeDfs(board, x , y + 1);
        changeDfs(board, x, y - 1);
    }

    public void revert(char[][] board, int x, int y){
        if(x < 0 || x == board.length || y < 0 || y == board[0].length){
            return;
        }
        if(board[x][y] == 'X' || board[x][y] == 'O'){
            return;
        }
        board[x][y] = 'O';
        revert(board, x + 1, y);
        revert(board, x - 1, y);
        revert(board, x , y + 1);
        revert(board, x, y - 1);
    }
}