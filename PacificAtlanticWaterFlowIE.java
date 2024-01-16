class Solution {
    boolean pacific = false;
    boolean atlantic = false;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList();
        for(int i = 0;i<=heights.length-1;i++){
            for(int j = 0;j<=heights[0].length-1;j++){

                int rows = heights.length;
                int columns = heights[0].length;
                int[][] copiedArray = new int[rows][columns];
                for (int m = 0; m < rows; m++) {
                    System.arraycopy(heights[m], 0, copiedArray[m], 0, columns);
                }
                dfs(copiedArray, i, j, heights[i][j]);
                if(atlantic && pacific){
                    List<Integer> coord = new ArrayList();
                    coord.add(i);
                    coord.add(j);
                    result.add(coord);
                }
                atlantic = false;
                pacific = false;
            }
        }
        return result;
    }

    public void dfs(int[][] heights, int x, int y, int preVal){
        if(x < 0 || x == heights.length || y < 0 || y == heights[0].length){
            return;
        }

        if(heights[x][y] > preVal){
            return;
        }
        if(x == heights.length-1 || y == heights[0].length-1 || x == 0 || y == 0){
            if(x == 0 || y == 0){
                pacific = true;
            }
            if(x == heights.length-1 || y == heights[0].length-1){
                atlantic = true;
            }
        }
        int val = heights[x][y];
        heights[x][y] = Integer.MAX_VALUE;
        dfs(heights, x + 1, y, val);
        dfs(heights, x - 1, y, val);
        dfs(heights, x, y + 1, val);
        dfs(heights, x, y - 1, val);
    }
}