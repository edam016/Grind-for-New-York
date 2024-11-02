class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] pac = new int[heights.length][heights[0].length];
        int[][] atl = new int[heights.length][heights[0].length];
        List<List<Integer>> result = new ArrayList();
        for(int i = 0;i<heights.length;i++){
            dfs(heights, pac, i, 0, 0);
        }
        for(int i = 0;i<heights.length;i++){
            dfs(heights, atl, i, heights[0].length-1, 0);
        }
        for(int i = 0;i<heights[0].length;i++){
            dfs(heights, pac, 0, i, 0);
        }
        for(int i = 0;i<heights[0].length;i++){
            dfs(heights, atl, heights.length - 1, i, 0);
        }

        int[][] res = new int[heights.length][heights[0].length];
        for(int i = 0;i<heights.length;i++){
            for(int j = 0;j<heights[0].length;j++){
                if(atl[i][j] == 1 && pac[i][j] == 1){
                    List<Integer> arr = new ArrayList();
                    arr.add(i);
                    arr.add(j);
                    result.add(arr);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, int[][] arr, int x, int y, int prevHeight){
        if(x < 0 || x >= heights.length || y < 0 || y >= heights[0].length){
            return;
        }
        if(heights[x][y] < prevHeight || arr[x][y] == 1){
            return;
        }
        arr[x][y] = 1;
        prevHeight = heights[x][y];
        dfs(heights, arr, x + 1, y, prevHeight);
        dfs(heights, arr, x - 1, y, prevHeight);
        dfs(heights, arr, x, y + 1, prevHeight);
        dfs(heights, arr, x, y - 1, prevHeight);
    }
}