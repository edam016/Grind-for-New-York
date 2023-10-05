class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0, start = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0;i<=fruits.length-1;i++){
            if(hm.containsKey(fruits[i])){
                hm.put(fruits[i], hm.get(fruits[i]) + 1);
            }
            else{
                hm.put(fruits[i], 1);
            }
            while(hm.size() > 2){
                if(hm.get(fruits[start]) > 1){
                    hm.put(fruits[start], hm.get(fruits[start]) - 1);
                }
                else{
                    hm.remove(fruits[start]);
                }
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}