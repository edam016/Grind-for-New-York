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

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hm = new HashMap();
        int left = 0;
        int right = 0;
        int size = 0;
        int maxSize = 0;
        while(right < fruits.length){
            if(hm.containsKey(fruits[right])){
                int val = hm.get(fruits[right]);
                hm.put(fruits[right], val + 1);
                size++;
            }
            else{
                hm.put(fruits[right], 1);
                size++;
            }
            while(hm.size() > 2){
                if(hm.get(fruits[left]) > 1){
                    int val = hm.get(fruits[left]) - 1;
                    hm.put(fruits[left], val);
                    size--;
                }
                else{
                    hm.remove(fruits[left]);
                    size--;
                }
                left++;
                }
            right++;
            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }
}