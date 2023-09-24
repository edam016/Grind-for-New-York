class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        List<Integer> arr = new ArrayList();
        int maxH = 0;
        long result = 0;
        for(int i = 0;i<=maxHeights.size()-1;i++){
            if(maxHeights.get(maxH) < maxHeights.get(i)){
                maxH = i;
                arr.clear();
                arr.add(i);
            }
            else if(maxHeights.get(maxH) == maxHeights.get(i)){
                arr.add(i);
            }
        }
        System.out.println("size"+arr.size());

        for(int index : arr){
            List<Integer> test = new ArrayList(maxHeights);
            result = Math.max(calculate(test, index), result);
        }
        return result;
    }
    public long calculate(List<Integer> maxHeights, int maxH){
            
        for(int i = maxH - 1;i>=1;i--){
            if(maxHeights.get(i) < maxHeights.get(i - 1)){
                maxHeights.set(i - 1, maxHeights.get(i));
            }
        }
        for(int i = maxH + 1;i<=maxHeights.size()-2;i++){
            if(maxHeights.get(i) < maxHeights.get(i + 1)){
                maxHeights.set(i + 1, maxHeights.get(i));
            }
        }
        long sum = 0;
        for(int i = 0;i<=maxHeights.size()-1;i++){
            sum += maxHeights.get(i);
        }
        return sum;
    }
}