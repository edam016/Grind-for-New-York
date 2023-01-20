public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] result = new int[2];
        int start = 0;
        int end = numbers.length-1;
        while(start < end){
            int total = numbers[start] + numbers[end];
            if(total == target){

                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
            if(total > target){
                end --;
            }
            if(total < target){
                start++;
            }
        }
        return result;
    }
} TwoSumINputArrayIsSorted {
    
}
