class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> sk = new Stack();
        for(int i = 0;i<pushed.length;i++){
            sk.push(pushed[i]);
            while(!sk.isEmpty() && sk.peek() == popped[j]){
                j++;
                sk.pop();
            }
        }
        return j == popped.length;
    }
}