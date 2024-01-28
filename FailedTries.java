class Solution {
    public int longestPalindromeSubseq(String s) {
        int maxLength = 0;
        for(int i = 0;i<s.length();i++){
            int length = Math.max(recursion(s, i, i, 0), recursion(s,i, i + 1, 0));
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    public int recursion(String s, int left, int right, int len){
        if(left < 0){
            return 0;
        }
        if(right == s.length()){
            return 0;
        }
        int l = 0, r = 0;
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                l = recursion(s, left - 1, right, len);
                r = recursion(s, left, right + 1, len);
                return Math.max(l, r);
            }
            len = Math.max(len, r - l - 1);
            left--;
            right++;
        }
        
        return len;
    }

}

class Solution {

    class Position {
        int x;
        int y;
        int diff;

        public Position(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }
    //use a visited array

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Integer> res = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        PriorityQueue<Position> q = new PriorityQueue<>((a, b) -> Integer.compare(a.diff, b.diff));
        q.offer(new Position(0, 0, 0));
        while (!q.isEmpty()) {
            Position pos = q.poll();
            if (pos.x == heights.length - 1 && pos.y == heights[0].length - 1) {
                res.offer(Math.abs(pos.diff - heights[heights.length - 1][heights[0].length - 1]));
            }
            if (pos.x + 1 < heights.length && heights[pos.x + 1][pos.y] != 0) {
                q.offer(new Position(pos.x + 1, pos.y,
                        Math.max(pos.diff, Math.abs(heights[pos.x + 1][pos.y] - heights[pos.x][pos.y]))));
                heights[pos.x + 1][pos.y] = Math.max(pos.diff,
                        Math.abs(heights[pos.x + 1][pos.y] - heights[pos.x][pos.y]));
            }
            if (pos.x - 1 >= 0 && heights[pos.x - 1][pos.y] != 0) {
                q.offer(new Position(pos.x - 1, pos.y,
                        Math.max(pos.diff, Math.abs(heights[pos.x - 1][pos.y] - heights[pos.x][pos.y]))));
                heights[pos.x - 1][pos.y] = Math.max(pos.diff,
                        Math.abs(heights[pos.x - 1][pos.y] - heights[pos.x][pos.y]));
            }
            if (pos.y + 1 < heights[0].length && heights[pos.x][pos.y + 1] != 0) {
                q.offer(new Position(pos.x, pos.y + 1,
                        Math.max(pos.diff, Math.abs(heights[pos.x][pos.y + 1] - heights[pos.x][pos.y]))));
                heights[pos.x][pos.y + 1] = Math.max(pos.diff,
                        Math.abs(heights[pos.x][pos.y + 1] - heights[pos.x][pos.y]));
            }
            if (pos.y - 1 >= 0 && heights[pos.x][pos.y - 1] != 0) {
                q.offer(new Position(pos.x, pos.y - 1,
                        Math.max(pos.diff, Math.abs(heights[pos.x][pos.y - 1] - heights[pos.x][pos.y]))));
                heights[pos.x][pos.y - 1] = Math.max(pos.diff,
                        Math.abs(heights[pos.x][pos.y - 1] - heights[pos.x][pos.y]));
            }
        }
        return res.poll();
    }
}