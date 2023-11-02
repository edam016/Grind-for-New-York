class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> sk = new Stack<Integer>();
        int[] result = new int[temperatures.length];
        for(int i = 0;i<=temperatures.length-1;i++){
            if(!sk.isEmpty() && temperatures[sk.peek()] < temperatures[i]){
                while(!sk.isEmpty() && temperatures[sk.peek()] < temperatures[i]){
                    result[sk.peek()] = i - sk.peek();
                    sk.pop();
                }
                sk.push(i);
            }
            else{
                sk.push(i);
            }
        }
        return result;
    }
}