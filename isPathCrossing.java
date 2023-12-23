class Solution {
    public boolean isPathCrossing(String path) {
        class Pair{
            int x;
            int y;
            public Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
            @Override
            public int hashCode(){
                return 30*x + y;
            }

            @Override
            public boolean equals(Object obj){
                Pair pair = (Pair) obj;
                if(pair.x == x && pair.y == y){
                    return true;
                }
                return false;
            }
        }
        HashSet<Pair> hs = new HashSet();
        int xCord = 0;
        int yCord = 0;
        Pair origin= new Pair(xCord, yCord);
        hs.add(origin);

        for(int i = 0;i<=path.length()-1;i++){
            switch(path.charAt(i)){
                case('N'):
                    yCord++;
                    break;
                case('W'):
                    xCord--;
                    break;
                case('E'):
                    xCord++;
                    break;
                case('S'):
                    yCord--;
                    break;
            }
            Pair pair = new Pair(xCord, yCord);
            if(!hs.add(pair)){
                return true;
            }
        }
        return false;
    }
}