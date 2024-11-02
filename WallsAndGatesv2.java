class Solution {

    class Position{
        int x;
        int y;
        int count;

        public Position(int x, int y, int count){
            this.x = x;
            this.y = y; 
            this.count = count;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        Queue<Position> q = new LinkedList();

        for(int i = 0;i<rooms.length;i++){
            for(int j = 0;j<rooms[0].length;j++){
                if(rooms[i][j] == 0){
                    q.offer(new Position(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            for(int i = 0;i < q.size();i++){
                Position pos = q.poll();
                if(pos.x + 1 < rooms.length && rooms[pos.x + 1][pos.y] == 2147483647){
                    rooms[pos.x + 1][pos.y] = pos.count + 1;
                    q.offer(new Position(pos.x + 1, pos.y, pos.count + 1));
                }
                if(pos.x - 1 >= 0 && rooms[pos.x - 1][pos.y] == 2147483647){
                    rooms[pos.x - 1][pos.y] = pos.count + 1;
                    q.offer(new Position(pos.x - 1, pos.y, pos.count + 1));
                }
                if(pos.y + 1 < rooms[0].length && rooms[pos.x][pos.y + 1] == 2147483647){
                    rooms[pos.x][pos.y + 1] = pos.count + 1;
                    q.offer(new Position(pos.x, pos.y + 1, pos.count + 1));
                }
                if(pos.y - 1 >= 0 && rooms[pos.x][pos.y - 1] == 2147483647){
                    rooms[pos.x][pos.y - 1] = pos.count + 1;
                    q.offer(new Position(pos.x, pos.y - 1, pos.count + 1));
                }
            }
        }
    }
}