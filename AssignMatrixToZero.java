class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    matrix = detect(matrix, i, j);
                }
            }
        }
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j] == Integer.MIN_VALUE+10){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public int[][] detect(int[][] matrix, int x, int y){
        for(int i = x;i>=0;--i){
            if(matrix[i][y] != 0){
                matrix[i][y] = Integer.MIN_VALUE+10;
            }
        }
        for(int i = x;i<=matrix.length-1;++i){
            if(matrix[i][y] != 0){
                matrix[i][y] = Integer.MIN_VALUE+10;
            }
        }
        for(int i = y;i>=0;--i){
            if(matrix[x][i] != 0){
                matrix[x][i] = Integer.MIN_VALUE+10;
            }
        }
        for(int i = y;i<=matrix[0].length-1;++i){
            if(matrix[x][i] != 0){
                matrix[x][i] = Integer.MIN_VALUE+10;
            }
        }
        return matrix;
    }
}