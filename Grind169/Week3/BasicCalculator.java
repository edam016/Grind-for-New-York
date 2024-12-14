class Solution {
    public int calculate(String s) {
        Stack<Integer> sk = new Stack();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number * 10 + (int)(c - '0');
            }
            else if(c == '+'){
                result += number * sign;
                number = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += number * sign;
                number = 0;
                sign = -1;
            }
            else if(c == '('){
                sk.push(result);
                sk.push(sign);
                result = 0;
                sign = 1;
            }
            else if(c == ')'){
                result += number * sign;
                number = 0;
                result *= sk.pop();
                result += sk.pop();
            }
        }

        if(number != 0){
            result += number * sign;
        }

        return result;
    }
}
/**

val + 

 */