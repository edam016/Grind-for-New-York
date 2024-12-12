class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[] interval = intervals[0];
        List<int[]> arr = new ArrayList();
        for(int i = 1;i<intervals.length;i++){
            int[] newInterval = intervals[i];
            if(interval[1] < newInterval[0]){
                arr.add(interval);
                interval = newInterval;
            }
            else if(interval[1] > newInterval[0]){
                return false;
            }
        }
        return true;
    }
}