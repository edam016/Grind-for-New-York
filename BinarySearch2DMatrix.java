class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length-1;
        int index = 0;
        int row1 = 0;
        int row2 = 0;
        while(top < bottom){
            int middle = (top + bottom)/2;
            if(target == matrix[top][0] || target == matrix[middle][0] || target == matrix[bottom][0]){
                return true;
            }
            else if(target >= matrix[top][0] && target <= matrix[top][matrix[0].length-1]){
                row1 = top;
                break;
            }
            else if(target >= matrix[middle][0] && target <= matrix[middle][matrix[0].length-1]){
                row1 = middle;
                break;
            }
            else if(target >= matrix[bottom][0] && target <= matrix[bottom][matrix[0].length-1]){
                row1 = bottom;
                break;
            }
            if(matrix[middle][0] > target){
                bottom = middle - 1;
            }
            else{
                top = middle + 1;
            }
        }
        System.out.println(row1);
        return binarySearch(matrix, target, row1);
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