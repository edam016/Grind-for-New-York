class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        int a,b = 0;
        Stack<String> stck = new Stack<String>();
        for(int i = 0;i<=tokens.length-1;i++){
            if("+-*/".contains(tokens[i])){
                switch(tokens[i]){
                    case "+":
                        result= (Integer.parseInt(stck.pop())+Integer.parseInt(stck.pop()));
                        System.out.println("+:"+result);
                        break;
                    case "-":
                        b = (Integer.parseInt(stck.pop()));
                        a = (Integer.parseInt(stck.pop())); 
                        result = a-b;
                        break;
                    case "*":
                        b = (Integer.parseInt(stck.pop()));
                        a = (Integer.parseInt(stck.pop())); 
                        result = a*b;
                        break;
                    case "/":
                        b = (Integer.parseInt(stck.pop()));
                        a = (Integer.parseInt(stck.pop())); 
                        result = a/b;
                        break;
                }
                stck.push(Integer.toString(result));

            }
            else{
                stck.push(tokens[i]);
            }
        }
        return (Integer.parseInt(stck.pop())); 
    }
}