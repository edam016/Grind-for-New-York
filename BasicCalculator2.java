class Solution {
    public int calculate(String s) {
        Stack<Integer> sk = new Stack();
        char operator = '+';
        int number = 0;
        int result = 0;

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                number = number * 10 + (int)(c - '0');
            }    

            if(isOp(c) || i == s.length() - 1){
                if(operator == '+'){
                    sk.push(number);
                }
                else if(operator == '-'){
                    sk.push(-number);
                }
                else if(operator == '*'){
                    sk.push(sk.pop()*number);
                }
                else if(operator == '/'){
                    sk.push(sk.pop()/number);
                }
                operator = c;
                number = 0;
            }
        }

        for(int val : sk){
            result += val;
        }
        return result;
    }

    public boolean isOp(Character c){
        return c == '+' || c == '-' || c =='*' || c == '/';
    }
}