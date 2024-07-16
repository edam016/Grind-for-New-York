class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        if(original.length != m*n){
            int[][] impossible = {};
            return impossible;
        }
        int currentRow = 0;
        for(int i = 0;i<original.length;i++){
            if(i%n == 0 && i != 0){
                currentRow++;
                result[currentRow][i%n] = original[i];
            }
            else{
                result[currentRow][i%n] = original[i];
            }
        }
        return result;
    }
}