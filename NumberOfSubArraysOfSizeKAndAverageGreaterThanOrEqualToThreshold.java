class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, average = 0, count = 0, start=0;
        for(int i = 0;i<=k-1;i++){
            sum += arr[i];
        }
        if(sum/k >= threshold) count++;
        for(int i = k; i<=arr.length-1;i++){
            sum += arr[i];
            sum -= arr[start];
            start++;
            average = sum / k;
            if(average >= threshold){
                count++;
            }
        }
        return count;
    }
}