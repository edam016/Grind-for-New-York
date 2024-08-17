class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int count = 0;
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        while(right < fruits.length){
            if(hm.containsKey(fruits[right])){
                hm.put(fruits[right], hm.getOrDefault(fruits[right], 0) + 1);
                count++;
            }
            else if(hm.size() >= 2){
                while(hm.size() >= 2){
                    if(hm.get(fruits[left]) == 1){
                        hm.remove(fruits[left]);
                    }
                    else{
                        hm.put(fruits[left], hm.get(fruits[left]) - 1);
                    }
                    count--;
                    left++;
                }
                hm.put(fruits[right], 1);
                count++;
            }
            else{
                hm.put(fruits[right], 1);
                count++;
            }
            right++;
            result = Math.max(result, count);
        }
        return result;
    }
}