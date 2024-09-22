class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hm = new HashMap();
        int maxVal = 0;
        for(int i = 0;i<wall.size();i++){
            int sum = 0;
            for(int j = 0;j<wall.get(i).size();j++){
                if(j == wall.get(i).size()-1){
                    continue;
                }
                sum += wall.get(i).get(j);
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        for(int val : hm.keySet()){
            
            maxVal = Math.max(hm.get(val), maxVal);
        }
        return wall.size() - maxVal;
    }
}