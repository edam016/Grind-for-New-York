class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int starting, int color){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == color|| image[sr][sc] != starting){
            return;
        }

        image[sr][sc] = color;
        dfs(image, sr + 1, sc, starting, color);
        dfs(image, sr - 1 , sc, starting, color);
        dfs(image, sr, sc + 1, starting, color);
        dfs(image, sr, sc - 1, starting, color);

    }
}