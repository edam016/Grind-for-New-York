class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stck = new Stack<Integer>();
        int [] result = new int [temperatures.length];
        for(int i = 0;i<=temperatures.length-1;i++){
            if(stck.isEmpty()){
                stck.push(i);
                continue;
            }
            else if(temperatures[i] > temperatures[stck.peek()]){
                while(!(stck.isEmpty()) && temperatures[i] > temperatures[stck.peek()]){
                    result[stck.peek()] = i - stck.peek();
                    stck.pop();
                }
                stck.push(i);
            }
            else{
                stck.push(i);
            }
        }
        return result;
    }
}