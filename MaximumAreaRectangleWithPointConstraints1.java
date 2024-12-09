class Solution {
    public int maxRectangleArea(int[][] points) {
        //use brute force to get the bottom left and top right

        HashSet<String> pointSet = new HashSet();
        int maxArea = -1;
        for(int[] point : points){
            pointSet.add(point[0]+","+point[1]);
        }

        for(int i = 0; i < points.length;i++){
            for(int j = i + 1; j < points.length;j++){
                int x1 = points[i][0];
                int x2 = points[j][0];
                int y1 = points[i][1];
                int y2 = points[j][1];
                boolean foundPoint = false;
                if(!pointSet.contains(x1+","+y2) || !pointSet.contains(x2+","+y1) || (x1 == x2) || (y1 == y2)){
                    continue;
                }
                for(int[] point : points){
                    if ((point[0] == x1 || point[0] == x2) && (point[1] == y1 || point[1] == y2)) {
                            continue;
                    }
                    if(point[0] > Math.min(x1, x2) && point[0] < Math.max(x1,x2) && point[1] > Math.min(y1, y2) && point[1] < Math.max(y1,y2)){
                        foundPoint = true;
                        break;
                    }
                    //edges check now
                    if((point[0] == x1 || point[0] == x2) && point[1] >= Math.min(y1,y2) && point[1] <= Math.max(y1,y2)){
                        foundPoint = true;
                        break;
                    }
                    if((point[1] == y1 || point[1] == y2) && point[0] >= Math.min(x1,x2) && point[0] <= Math.max(x1,x2)){
                        foundPoint = true;
                        break;
                    }
                }

                if(!foundPoint){
                    maxArea = Math.max(maxArea, (x2 - x1) * (y2 - y1));
                }
            }
        }
        return maxArea == 0 ? -1 : maxArea;
    }
}