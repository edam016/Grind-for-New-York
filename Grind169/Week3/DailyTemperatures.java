class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> sk = new Stack();
        int[] result = new int[temperatures.length];
        for(int i = 0;i<temperatures.length;i++){
            int temp = temperatures[i];
            if(sk.isEmpty()){
                sk.push(i);
                continue;
            }
            while(!sk.isEmpty() && temperatures[sk.peek()] < temp){
                result[sk.peek()] = i - sk.peek();
                sk.pop();
            }
            sk.push(i);
        }
        return result;
    }
}