
class TimeMap {

    HashMap<String, TreeMap<Integer, String>> hm;
    public TimeMap(){
        hm = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.containsKey(key)){
            TreeMap<Integer, String> hmGet = hm.get(key);
            hmGet.put(timestamp, value);
        }
        else{
            TreeMap<Integer, String> hmGet = new TreeMap();
            hmGet.put(timestamp, value);
            hm.put(key, hmGet);
        }
    }
    
    public String get(String key, int timestamp) {
        if(hm.containsKey(key)){
            TreeMap<Integer, String> hmGet = hm.get(key);
            Integer floorKey = hmGet.floorKey(timestamp);
            if(floorKey != null){
                return hmGet.get(floorKey);
            }
        }

        return "";
    }
}

class TimeMap {

    class Pair{
        int timestamp;
        String value;

        public Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    HashMap<String, List<Pair>> hm;
    int maxStamp = Integer.MIN_VALUE;
    public TimeMap() {
        hm = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.containsKey(key)){
            List<Pair> arr = hm.get(key);
            arr.add(new Pair(timestamp, value));
            hm.put(key, arr);
        }
        else{
            List<Pair> arr = new ArrayList();
            arr.add(new Pair(timestamp, value));
            hm.put(key, arr);
        }
        maxStamp = Math.max(maxStamp, timestamp);
    }
    
    public String get(String key, int timestamp){
        if(hm.containsKey(key)){
            List<Pair> arr = hm.get(key);
            int left = 0;
            int right = arr.size()-1;

            while(left <= right){
                int middle = left + (right - left)/2;
                if(arr.get(middle).timestamp == timestamp){
                    return arr.get(middle).value;
                }
                if(arr.get(middle).timestamp < timestamp){
                    
                    left = middle + 1;
                }
                else{
                    right = middle - 1;
                }
            }
/**
 * If no exact match is found, the binary search concludes with:
 * - 'left' pointing to the smallest timestamp greater than the target.
 * - 'right' pointing to the largest timestamp less than or equal to the target.
 *
 * Therefore:
 * - To retrieve the value with the smallest timestamp greater than the target, use 'left'.
 * - To retrieve the value with the largest timestamp less than or equal to the target, use 'right'.
 */
        return right >= 0 && arr.get(right).timestamp <= timestamp ? arr.get(right).value : "";
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */