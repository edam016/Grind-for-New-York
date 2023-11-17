class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //find out which number ranges it is in on left side then binary search the rest
        int row = 0;
        for(int i = 0;i<=matrix.length-1;i++){
            if(matrix[i][0] <= target){
                row = i;
            }
        }
        int left = 0, right = matrix[row].length-1;
        while(left < right){
            int middle = (left + right)/2;
            if(matrix[row][middle] == target){
                return true;
            }
            if(matrix[row][middle] > target){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        return matrix[row][left] == target;
    }
}