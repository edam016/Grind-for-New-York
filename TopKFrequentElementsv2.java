class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //each index is how many times it has occurred
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        int [] result = new int[k];
        int counter = 0;
        for(int i = 0;i<=nums.length-1;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }
            else{
                hm.put(nums[i], 1);
            }
        }
        for(int i = 0;i<=nums.length;i++){
            List<Integer> ph = new ArrayList<Integer>();
            arr.add(ph);
        }
        int maxVal = 0;
        for(int val : hm.keySet()){
            arr.get(hm.get(val)).add(val);
            maxVal = Math.max(maxVal, hm.get(val));
        }

        for(int i = maxVal;i>=0;i--){
            if(counter == k){
                break;
            }
            if(arr.get(i) != null){
                for(int j = 0; j<=arr.get(i).size()-1;j++){
                    result[counter] = arr.get(i).get(j);
                    counter++;
                }
            }
        }
        return result;
    }
}