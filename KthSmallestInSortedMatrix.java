class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                q.offer(matrix[i][j]);
                if(q.size() > k){
                    q.poll();
                }
            }
        }
        return q.peek();
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int min = matrix[0][0];
        int max = matrix[matrix.length-1][matrix[0].length-1];
        int middle = 0;
        int count = 0;

        while(min < max){
            middle = (min + max)/ 2;
            count = isLessThan(matrix, middle);
            if(count < k){
                min = middle + 1;
            }
            else{
                max = middle - 1;
            }
        }
        return min;
    }

    public int isLessThan(int[][] matrix, int middle){
        int column = matrix[0].length-1;
        int row = 0;
        int count = 0;
        while(row < matrix.length && column >= 0){
            if(matrix[column][row] < middle){
                count+= column + 1;
                row++;
            }
            else{
                column--;
            }
        }
        return count;
    }
}