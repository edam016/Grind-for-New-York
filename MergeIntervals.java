class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> arr = new ArrayList();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        arr.add(intervals[0]);
        for(int i = 1;i<=intervals.length-1;i++){
            if(intervals[i][0] <= arr.get(arr.size()-1)[1]){
                arr.get(arr.size()-1)[1] = Math.max(intervals[i][1], arr.get(arr.size()-1)[1]);
            }
            else{
                arr.add(intervals[i]);
            }
        }
        return arr.toArray(new int[arr.size()][2]);
    }
}