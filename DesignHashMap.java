class MyHashMap {
    int[] result;
    public MyHashMap() {
        result = new int[10000001];
        Arrays.fill(result, -1);
    }
    
    public void put(int key, int value) {
        result[key] = value;
    }
    
    public int get(int key) {
        return result[key];
    }
    
    public void remove(int key) {
        result[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */