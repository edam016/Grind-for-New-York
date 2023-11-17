class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<=weights.length-1;i++){
            maxVal = Math.max(weights[i], maxVal);
            sum += weights[i];
        }
        int[] arr = new int [sum];
        int left = 0, right = arr.length-1, middle = 0;
        for(int i = 0;i<=arr.length-1;i++){
            arr[i] = i+1;
        }
        while(left <= right){
            middle = (left + right)/2;
            if(maxVal > arr[middle] || !checkVal(weights, days, arr[middle])){
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }
        return left + 1;
    }
    public boolean checkVal(int[] weights, int days, int capacity){
        int total = 0, index = 0, count = 0;
        while(index <= weights.length-1){
            total = weights[index] + total;
            if(total > capacity){
                total = weights[index];
                count++;
            }
            else if(total == capacity){
                total = 0;
                count++;
            }
            index++;
        }
        if(total > 0){
            count++;
        }
        return count <= days;
    }
}