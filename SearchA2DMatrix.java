class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length-1;

        int top = matrix.length-1;
        int bottom = 0;

        while(top > bottom){
            int middle = bottom + (top - bottom)/2;
            if(target > matrix[middle][matrix[0].length-1]){
                bottom = middle + 1;
            }
            else{
                top = middle;
            }
        }
        while(left < right){
            int middle = left + (right - left)/2;
            if(target > matrix[bottom][middle]){
                left = middle + 1;
            }
            else{
                right = middle;
            }
        }

        return matrix[bottom][left] == target;
    }
}