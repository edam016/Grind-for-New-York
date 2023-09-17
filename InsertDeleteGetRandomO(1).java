class RandomizedSet {
    HashMap<Integer, Integer> hm;
    List<Integer> arr;  
    public RandomizedSet() {
        hm = new HashMap();
        arr = new ArrayList();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            return false;
        }
        else{
            hm.put(val, arr.size());
            arr.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)){
            return false;
        }
        else{
            int ind = hm.get(val);
            int lastId = arr.size()-1;
            if(ind != lastId){
                int last = arr.get(lastId);
                hm.put(last, ind);
                arr.set(ind, last);
            }
            hm.remove(val);
            arr.remove(lastId);
            return true;
        }
        
    }
    
    public int getRandom() {
        Random random = new Random();
        return arr.get(random.nextInt(hm.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */