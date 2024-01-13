class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> hm = new HashMap();
        long count = 0;
        for(int i = 0;i<=rectangles.length-1;i++){
            Double b = (double) rectangles[i][0]/rectangles[i][1];
            if(hm.containsKey(b)){
                hm.put(b, hm.get(b) + 1);
                count += hm.get(b);
            }
            else{
                hm.put(b, 0);
            }
        }
        return count;
    }
}