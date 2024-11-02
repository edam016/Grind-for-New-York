class Solution {
    public void solve(char[][] board) {

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 'O'){
                    if(check(board, i, j)){
                        change(board, i, j);
                    }
                    else{
                        reverse(board, i, j);
                    }
                }
            }
        }
    }

    public boolean check(char[][] board, int x, int y){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length){
            return true;
        }
        if(board[x][y] == 'X' || board[x][y] == 'C'){
            return false;
        }
        board[x][y] = 'C';
        return check(board,  x + 1, y) || check(board, x - 1, y) || check(board, x, y + 1) || check(board, x, y - 1);
    }

    public void change(char[][] board, int x, int y){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == 'O' || board[x][y] == 'X'){
            return;
        }
        if(board[x][y] == 'C'){
            board[x][y] = 'O';
        }
        change(board,  x + 1, y);
        change(board, x - 1, y);
        change(board, x, y + 1);
        change(board, x, y - 1);
    }

    public void reverse(char[][] board, int x, int y){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == 'X'){
            return;
        }
        if(board[x][y] == 'C'){
            board[x][y] = 'X';
        }
        reverse(board, x + 1, y);
        reverse(board, x - 1, y);
        reverse(board, x, y + 1);
        reverse(board, x, y - 1);
    }
}