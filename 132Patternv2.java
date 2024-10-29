class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> sk = new Stack();
        int secondVal = Integer.MIN_VALUE;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i] < secondVal){
                return true;
            }
            else if(!sk.isEmpty() && sk.peek() < nums[i]){
                while(!sk.isEmpty() && sk.peek() < nums[i]){
                    secondVal = sk.pop();
                }
                sk.push(nums[i]);
            }
            else{
                sk.push(nums[i]);
            }
        }
        return false;
    }
}