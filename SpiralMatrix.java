class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList();
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin;i<=colEnd;i++){
                order.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for(int i = rowBegin;i<=rowEnd;i++){
                order.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegin <= rowEnd){
                for(int i = colEnd;i>=colBegin;i--){
                    order.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            if(colBegin <= colEnd){
                for(int i = rowEnd;i>=rowBegin;i--){
                    order.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }
        return order;
    }
}