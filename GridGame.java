public class Solution {
    public long gridGame(int[][] grid) {
        long top = 0, bottom = 0, result = Long.MAX_VALUE;
        for(int i = 0;i<=grid[0].length-1;i++){
            top += grid[0][i];
        }
        for(int i = 0;i<=grid[0].length-1;++i){
            top -= grid[0][i];
            result = Math.min(result, Math.max(top, bottom));
            bottom += grid[1][i];
        }
        return result;
    }
} 