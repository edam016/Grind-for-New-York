class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> sk = new Stack<Integer>();
        int pop = 0;
        int push = 0;
        for(int i = 0;i<=pushed.length-1;i++){
            sk.push(pushed[push]);
            while(!sk.isEmpty() && sk.peek() == popped[pop]){
                sk.pop();
                pop++;
            }
            push++;
        }
        return pop==popped.length;
    }
}