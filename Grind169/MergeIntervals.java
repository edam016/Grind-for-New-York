class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            int[][] result = new int[1][1];
            result[0] = newInterval;
            return result;
        }
        else if(newInterval.length == 0){
            return intervals;
        }
        List<int[]> arr = new ArrayList();
        boolean merged = false;
        for(int i = 0;i<intervals.length;i++){
            if(intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0] ||
               intervals[i][1] >= newInterval[1] && intervals[i][0] <= newInterval[1] ||
               newInterval[1] >= intervals[i][1] && newInterval[0] <= intervals[i][0]
               ){
                intervals[i][0] = Math.min(newInterval[0], intervals[i][0]);
                intervals[i][1] = Math.max(newInterval[1], intervals[i][1]);
                merged = true;
            }
        }
        for(int i = 0;i<intervals.length;i++){
            if(arr.isEmpty()){
                arr.add(intervals[i]);
            }
            else if(arr.get(arr.size()-1)[1] >= intervals[i][0]){
                int[] add = new int[2];
                add[0] = Math.min(arr.get(arr.size()-1)[0], intervals[i][0]);
                add[1] = Math.max(arr.get(arr.size()-1)[1], intervals[i][1]);
                arr.remove(arr.size()-1);
                arr.add(add);
            }
            else{
                arr.add(intervals[i]);
            }
        }
        if(!merged){
            arr.add(newInterval);
        }
        int[][] result = new int[arr.size()][2];
        int index = 0;

        for(int[] array : arr){
            result[index] = array;
            index++;
        }
        Arrays.sort(result, (a,b) -> Integer.compare(a[0], b[0]));
        return result;
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arr = new ArrayList();
        for(int[] interval : intervals){

            //Deals with when newInterval occurs before so newInterval is next one as original newInterval does nothing
            if(interval[0] > newInterval[1]){
                arr.add(newInterval);
                newInterval = interval;
            }

            //If newInterval is above interval, just slot interval in
            else if(interval[1] < newInterval[0]){
                arr.add(interval);
            }
            else{
                //Combine the interval with the new one, by using it as the new interval, we can then use this to judge future ones. If future ones are not affected by it, case 1 and 2  suffice
                // to cover. Otherwise newInterval persists and if it joins everything else up to this point, the last arr.add outside the for loop adds it in
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        arr.add(newInterval);
        return arr.toArray(new int[arr.size()][]);

    }
}