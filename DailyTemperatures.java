class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> sk = new Stack();
        //use a monolithic stack in this case to track temperatures
        int[] result = new int[temperatures.length];
        int total = 0;
        for(int i = 0;i<temperatures.length;i++){
            if(sk.isEmpty()){
                sk.push(i);
            }
            while(!sk.isEmpty() && temperatures[sk.peek()] < temperatures[i]){
                result[sk.peek()] = i - sk.peek();
                sk.pop();
            }
            sk.push(i);
        }
        return result;
    }
}