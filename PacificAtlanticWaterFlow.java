class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList();
        if(heights.length == 0){
            return res;
        }
        int[][] atlantic = new int[heights.length][heights[0].length];
        int[][] pacific = new int[heights.length][heights[0].length];

        for(int i = 0;i<=heights.length-1;i++){
            dfs(heights, i, 0, 0, pacific);
            dfs(heights, i, heights[0].length-1, 0, atlantic);
        }

        for(int i = 0;i<=heights[0].length-1;i++){
            dfs(heights, 0, i, 0, pacific);
            dfs(heights, heights.length-1, i, 0, atlantic);
        }

        for(int i = 0;i<=heights.length-1;i++){
            for(int j = 0;j<=heights[0].length-1;j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    List<Integer> match = new ArrayList();
                    match.add(i);
                    match.add(j);
                    res.add(match);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, int x, int y, int prev, int[][] ocean){
        if(x < 0 || x == heights.length || y < 0 || y == heights[0].length){
            return;
        }
        if(prev > heights[x][y]){
            return;
        }
        if(ocean[x][y] == 1){
            return;
        }
        ocean[x][y] = 1;
        dfs(heights, x + 1, y, heights[x][y], ocean);
        dfs(heights, x - 1, y, heights[x][y], ocean);
        dfs(heights, x, y + 1, heights[x][y], ocean);
        dfs(heights, x, y - 1, heights[x][y], ocean);
    }
}