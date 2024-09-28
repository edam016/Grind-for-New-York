class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        int total = 0;
        for(int val : nums){
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }

        for(int val : hm.keySet()){
            if(hm.get(val) == 1){
                return -1;
            }
            else if(hm.get(val)%3 == 0){
                total += hm.get(val)/3;
            }
            else if(hm.get(val)%3 == 1 || hm.get(val)%3 == 2){
                total += hm.get(val)/3 + 1;
            }
            else if(hm.get(val)%2 == 0){
                total += hm.get(val)/2;
            }
        }
        return total;
    }
}