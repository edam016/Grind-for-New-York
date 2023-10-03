class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int [] counter = new int[mat.length];
        int [] result = new int[k];
        int count = 0;
        for(int i = 0;i<=mat.length-1;i++){
            for(int j = 0;j<=mat[i].length-1;j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            counter[i] = count;
            count = 0;
        }
        int minVal = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0;i<k;i++){
            for(int j = 0;j<=counter.length-1;j++){
                if(minVal > counter[j]){
                    minVal = counter[j];
                    index = j;
                }
            }
            result[i] = index;
            counter[index] = Integer.MAX_VALUE;
            minVal = Integer.MAX_VALUE;
        }
        return result;
    }
}