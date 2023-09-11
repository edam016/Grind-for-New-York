public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int maxAmount= 0;
        for(List<Integer> row: wall){
            int total = 0;
            for(int j = 0;j<=row.size()-2;j++){
                total += row.get(j);
                hm.put(total, hm.getOrDefault(total, 0) + 1);
                maxAmount = Math.max(maxAmount, hm.get(total)); 
            }
        }
        return wall.size() - maxAmount;
    }
} {
    
}
