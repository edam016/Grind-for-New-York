class Solution {
    public boolean find132pattern(int[] nums) {
        
        class Pair{
            int value;
            int min;
            Pair(int value, int min){
                this.value = value;
                this.min = min;
            }
        }

        Stack<Pair> sk = new Stack();
        int minVal = Integer.MAX_VALUE;

        for(int i = 0;i<=nums.length-1;i++){
            Pair pair = null;
            if(sk.isEmpty()){
                pair = new Pair(nums[i], minVal);
                sk.push(pair);
                continue;
            }
            if(!sk.isEmpty() && sk.peek().value > nums[i] && nums[i] > sk.peek().min){
                return true;
            }
            if(!sk.isEmpty() && sk.peek().value < nums[i]){
                while(!sk.isEmpty() && sk.peek().value < nums[i]){
                    minVal = Math.min(nums[i-1], minVal);
                    sk.pop();
                    if(!sk.isEmpty() && sk.peek().value > nums[i] && nums[i] > sk.peek().min){
                        return true;
                        }
                }
                pair = new Pair(nums[i], minVal);
                sk.push(pair);
            }
            else{
                minVal = Math.min(nums[i-1], minVal);
                pair = new Pair(nums[i], minVal);
                sk.push(pair);
            }
        }
        return false;
    }
}