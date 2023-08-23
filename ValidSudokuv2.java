class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<=board.length-1;i++){
            HashSet<Character> hs = new HashSet<Character>();
            for(int j = 0;j<=board[i].length-1;j++){
                int row = j/3 + (3*(i/3));
                int column = j%3 + (3*(i%3));
                if((Character.isDigit(board[row][column]) && (!(hs.add(board[row][column]))))){
                    return false;
                }
            }
            hs.clear();
        }
        for(int i = 0;i<=board.length-1;i++){
            HashSet<Character> hsRow = new HashSet<Character>();
            HashSet<Character> hsCol = new HashSet<Character>();
            for(int j = 0;j<=board[i].length-1;j++){
                if((Character.isDigit(board[i][j]) && !(hsRow.add(board[i][j])))){
                    System.out.println("2");
                    return false;
                }
                if((Character.isDigit(board[j][i]) && !(hsCol.add(board[j][i])))){
                    System.out.println("3");
                    return false;
                }
            }
            hsRow.clear();
            hsCol.clear();
        }
        return true;
    }
}