class Solution {
    public void gameOfLife(int[][] board) {
        int[][] next = new int[board.length][board[0].length];
        
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 1){
                    if(i < board.length - 1){
                        next[i+1][j]++;
                    }
                    if(j < board[0].length-1){
                        next[i][j+1]++;
                    }
                    if(i > 0){
                        next[i-1][j]++;
                    }
                    if(j > 0){
                        next[i][j-1]++;
                    }
                    if(i < board.length - 1 && j < board[0].length - 1){
                        next[i+1][j+1]++;
                    }
                    if(j < board[0].length - 1 && i > 0){
                        next[i-1][j+1]++;
                    }
                    if(i > 0 && j > 0){
                        next[i-1][j-1]++;
                    }
                    if(j > 0 && i < board.length - 1){
                        next[i+1][j-1]++;
                    }
                }
            }
        }

        for(int i = 0;i<next.length;i++){
            for(int j = 0;j<next[0].length;j++){
                System.out.print(next[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("break");
        for(int i = 0;i<next.length;i++){
            for(int j = 0;j<next[0].length;j++){
                if(next[i][j] == 1 && board[i][j] == 1){
                    board[i][j] = 0;
                }
                else if((next[i][j] == 2 || next[i][j] == 3) && board[i][j] == 1){
                    board[i][j] = 1;
                }
                else if(next[i][j] > 3 && board[i][j] == 1){
                    board[i][j] = 0;
                }
                else if(next[i][j] == 3 && board[i][j] == 0){
                    board[i][j] = 1;
                }
                else{
                    board[i][j] = 0;
                }
            }
        }
    }
}