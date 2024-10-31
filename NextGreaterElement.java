class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //double the array to account for circular arrays
        if(nums.length == 0){
            return new int[0];
        }
        int[] newArr = new int[nums.length*2];
        int[] res = new int[nums.length];
        int j = nums.length;
        for(int i = 0;i<nums.length;i++){
            newArr[i] = nums[i];
            newArr[j] = nums[i];
            j++;
        }

        Stack<Integer> sk = new Stack();

        for(int i = newArr.length-1;i>=0;i--){
            if(sk.isEmpty()){
                sk.push(newArr[i]);
            }
            else if(!sk.isEmpty() && newArr[i] >= sk.peek()){
                while(!sk.isEmpty() && newArr[i] >= sk.peek()){
                    sk.pop();
                }
                if(sk.isEmpty()){
                    sk.push(newArr[i]);
                    newArr[i] = -1;
                }
                else{
                    int temp = newArr[i];
                    newArr[i] = sk.peek();
                    sk.push(temp);
                }
            }
            else{
                int temp = newArr[i];
                newArr[i] = sk.peek();
                sk.push(temp);
            }
        }
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            result[i] = newArr[i];
        }

        return result;
    }
}