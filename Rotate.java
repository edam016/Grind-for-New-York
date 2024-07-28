class Solution {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;
        int top = 0;
        int bottom = 0;
        int temp = 0;

        while(left < right){
            top = left;
            bottom = right;
            for(int i = 0;i<right - left;i++){

                temp = matrix[top][left+i];

                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = temp; 

            }
            left++;
            right--;
        }
    }
}