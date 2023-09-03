class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length-1;
        while(top < bottom){
            int middle = (top + bottom)/2;
            if(matrix[middle][0] <= target && matrix[middle][matrix[0].length-1] >= target){
                return binarySearch(matrix, target, middle);
            }
            else if(matrix[middle][0] > target){
                bottom = middle - 1;
            }
            else if(matrix[middle][matrix[0].length-1]< target){
                top = middle + 1;
            }
        }
        return binarySearch(matrix, target, top);
    }

    public boolean binarySearch(int[][] matrix, int target, int index){
        int start = 0;
        int end = matrix[0].length-1;
        while(start < end){
            int middle = (start + end)/2;
            if(matrix[index][middle] == target){
                return true;
            }
            else if(matrix[index][middle] > target){
                end = middle - 1;
            }
            else{
                start = middle + 1;
            }
        }
        return target == matrix[index][start]? true : false;
    }
}