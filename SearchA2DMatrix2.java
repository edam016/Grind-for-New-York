class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int i = 0;i<matrix.length;i++){
            int left = 0;
            int right = matrix[0].length-1;
            while(left < right){
                int middle = left + (right - left)/2;
                if(matrix[i][middle] == target){
                    return true;
                }
                if(target > matrix[i][middle]){
                    left = middle + 1;
                }
                else{
                    right = middle;
                }
            }
            if(matrix[i][left] == target){
                return true;
            }
        }


        return false;
    }
}