class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<=weights.length-1;i++){
            maxVal = Math.max(weights[i], maxVal);
            sum += weights[i];//sum is upperbound as 1 massive boat can be used
        }
        int left = 0, right = sum, middle = 0;
        while(left < right){
            middle = (left + right)/2;
            if(maxVal > middle || !checkVal(weights, days, middle)){
                left = middle + 1;
            }
            else{
                right = middle; // no need for -1 as middle might be the last one that works so keep in solution set
            }
        }
        return left;
    }
    public boolean checkVal(int[] weights, int days, int capacity){
        int total = 0, count = 0;
        for(int index = 0;index<=weights.length-1;index++){
            total = weights[index] + total;
            if(total > capacity){
                total = weights[index];
                count++;
            }
            else if(total == capacity){
                total = 0;
                count++;
            }
        }
        if(total > 0){
            count++;
        }
        return count <= days;
    }
}