class Solution {

    class Position{
        int x;
        int y;
        int dist;
        public Position(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        if(entrance.length == 0 || maze.length == 0 || maze == null || entrance == null){
            return 0;
        }
        Queue<Position> q = new LinkedList();
        HashSet<String> hs = new HashSet();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<maze.length;i++){
            if(maze[i][0] == '.'){
                sb.append(i);
                sb.append(0);
                if(hs.add(sb.toString())){
                    q.offer(new Position(i, 0, 0));
                }
                sb.setLength(0);
            }
            
            if(maze[i][maze[0].length-1] == '.'){
                sb.append(i);
                sb.append(maze[0].length-1);
                if(hs.add(sb.toString())){
                    q.offer(new Position(i, maze[0].length-1, 0));
                }
                sb.setLength(0);
            }
        }

        for(int i = 0;i<maze[0].length;i++){
            if(maze[0][i] == '.'){
                sb.append(0);
                sb.append(i);
                if(hs.add(sb.toString())){
                    q.offer(new Position(0, i, 0));
                }
                sb.setLength(0);
            }
            if(maze[maze.length-1][i] == '.'){
                sb.append(maze.length-1);
                sb.append(i);
                if(hs.add(sb.toString())){
                    q.offer(new Position(maze.length-1, i, 0));
                }
                sb.setLength(0);
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Position pos = q.poll();
                if(pos.x == entrance[0] && pos.y == entrance[1]){
                    if(pos.dist != 0){
                        return pos.dist;
                    }
                    continue;
                }
                if(pos.x + 1 < maze.length && maze[pos.x + 1][pos.y] == '.'){
                    maze[pos.x + 1][pos.y] = '+';
                    q.offer(new Position(pos.x + 1, pos.y, pos.dist + 1));
                }
                if(pos.x - 1 >= 0 && maze[pos.x - 1][pos.y] == '.'){
                    maze[pos.x - 1][pos.y] = '+';
                    q.offer(new Position(pos.x - 1, pos.y, pos.dist + 1));
                }
                if(pos.y + 1 < maze[0].length && maze[pos.x][pos.y + 1] == '.'){
                    maze[pos.x][pos.y + 1] = '+';
                    q.offer(new Position(pos.x, pos.y + 1, pos.dist + 1));
                }
                if(pos.y - 1 >= 0 && maze[pos.x][pos.y - 1] == '.'){
                    maze[pos.x][pos.y - 1] = '+';
                    q.offer(new Position(pos.x, pos.y - 1, pos.dist + 1));
                }
            }
        }
        return -1;
    }
}