class TimeMap {

    class Pair{
        String value;
        int time;
        public Pair(String value, int time){
            this.value = value;
            this.time = time;
        }
    }

    HashMap<String, List<Pair>> hm;

    public TimeMap() {
        hm = new HashMap();    
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.containsKey(key)){
            List<Pair> arr = hm.get(key);
            Pair pair = new Pair(value, timestamp);
            arr.add(pair);
            hm.put(key, arr);
        }
        else{
            List<Pair> arr = new ArrayList();
            Pair pair = new Pair(value, timestamp);
            arr.add(pair);
            hm.put(key, arr);
        }
    }
    
    public String get(String key, int timestamp) {
        int left = 0, right = 0;
        String res = "";
        if(hm.containsKey(key)){
            right = hm.get(key).size()-1;
        }
        else{
            return "";
        }
        while(left <= right){
            int middle = (left + right)/2;
            if(hm.get(key).get(middle).time == timestamp){
                return hm.get(key).get(middle).value;
            }
            if(hm.get(key).get(middle).time < timestamp){
                res = hm.get(key).get(right).value; 
                //left counter is incremented and when timestamp is not found it remains at left counter which is at largest element due to this line
                //since left <= right, it is needed as the result is taken here an
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }
        return right >= 0 ? hm.get(key).get(right).value : "";
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */