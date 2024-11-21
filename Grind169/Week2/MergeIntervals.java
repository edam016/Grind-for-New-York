class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> arr = new ArrayList();
        int[] interval = intervals[0];
        for(int i = 1;i<intervals.length;i++){
            if(interval[1] < intervals[i][0]){
                arr.add(interval);
                interval = intervals[i];
            }
            else if(interval[0] > intervals[i][1]){
                arr.add(intervals[i]);
            }
            else{
                interval[0] = Math.min(interval[0], intervals[i][0]);
                interval[1] = Math.max(interval[1], intervals[i][1]);
            }
        }
        
        arr.add(interval);
        int[][] result = new int[arr.size()][2];
        int index = 0;
        
        for(int[] ints : arr){
            result[index] = ints;
            index++;
        }

        return result;
    }
}