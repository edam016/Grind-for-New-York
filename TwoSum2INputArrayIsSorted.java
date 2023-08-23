class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        int [] arr = new int [2];
        while(start < end){
            int value = numbers[start] + numbers[end];
            if(value == target){
                arr[0] = start+1;
                arr[1] = end + 1;
                break;
            }
            if(value > target){
                end--;
            }
            else{
                start++;
            }
        }
        return arr;
    }
}