class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stck = new Stack<String>();
        int a, b, result = 0;
        for(int i = 0;i<=tokens.length-1;i++){
            switch(tokens[i]){
                case "+":
                    a = Integer.parseInt(stck.pop());
                    b = Integer.parseInt(stck.pop());
                    result = a + b;
                    stck.push(String.valueOf(result));
                    break;
                case "-":
                    a = Integer.parseInt(stck.pop());
                    b = Integer.parseInt(stck.pop());
                    result = b - a;
                    stck.push(String.valueOf(result));
                    break;
                case "*":
                    a = Integer.parseInt(stck.pop());
                    b = Integer.parseInt(stck.pop());
                    result = a * b;
                    stck.push(String.valueOf(result));
                    break;
                case "/":
                    a = Integer.parseInt(stck.pop());
                    b = Integer.parseInt(stck.pop());
                    result = b/a;
                    stck.push(String.valueOf(result));
                    break;
                default:
                    stck.push(tokens[i]);
            }
        }
        return Integer.parseInt(stck.peek());
    }
}