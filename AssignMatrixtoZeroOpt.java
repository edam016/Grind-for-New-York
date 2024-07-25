class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row0 = false, col0 = false;

        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                col0 = true;
            }
        }

        for(int i = 0;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                row0 = true;
            }
        }

        for(int i = 1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0;i<matrix[0].length;i++){
            if(row0){
                matrix[0][i] = 0;
            }
        }

        for(int j = 0;j<matrix.length;j++){
            if(col0){
                matrix[j][0] = 0;
            }
        }

        

    }
}