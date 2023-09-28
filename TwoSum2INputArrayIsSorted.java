class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                break;
            }
            if(sum > target){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[]{i+1, j+1};
    }
}