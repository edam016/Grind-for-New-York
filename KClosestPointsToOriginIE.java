class Solution {

    class Data{
        Double distance;
        int[] points;
        public Data(Double distance, int[] points){
            this.distance = distance;
            this.points = points;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        List<Data> arr = new ArrayList();
        for(int i = 0;i<points.length;i++){
            Double dist = (double)Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            arr.add(new Data(dist, points[i]));
        }
        Collections.sort(arr, (a,b) -> a.distance.compareTo(b.distance));
        int[][] result = new int[k][];
        for(int i = 0;i<result.length;i++){
            result[i] = arr.get(i).points;
        }
        return result;
    }
}