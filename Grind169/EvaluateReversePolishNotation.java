class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> sk = new Stack();
        for(int i = 0;i<tokens.length;i++){
            if(sk.isEmpty()){
                sk.push(Integer.parseInt(tokens[i]));
            }
            else if(tokens[i].equals("+")){
                int a = sk.pop();
                int b = sk.pop();
                sk.push(a + b);
            }
            else if(tokens[i].equals("-")){
                int a = sk.pop();
                int b = sk.pop();
                sk.push(b - a);
            }
            else if(tokens[i].equals("*")){
                int a = sk.pop();
                int b = sk.pop();
                sk.push(a * b);
            }
            else if(tokens[i].equals("/")){
                int a = sk.pop();
                int b = sk.pop();
                sk.push(b/a);
            }
            else{
                sk.push(Integer.parseInt(tokens[i]));
            }
        }
        return sk.peek();
    }
}