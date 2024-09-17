class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int peak = 0;
        int index = 0;

        while(left < right){
            int middle = left + (right - left)/2;
            if(arr[middle] > peak){
                peak = arr[middle];
                index = middle;
            }
            if(arr[middle] > arr[middle + 1]){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        return arr[left] > peak ? left : index;
    }
}