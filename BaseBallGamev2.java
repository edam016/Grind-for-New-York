class Solution {
    public int calPoints(String[] operations) {
        Stack<String> sk = new Stack();
        for(String val : operations){
            if(val.equals("+") && sk.size() >= 2){
                String top = sk.pop();
                int a = Integer.parseInt(String.valueOf(sk.peek()));
                int b = Integer.parseInt(String.valueOf(top));
                sk.push(top);
                sk.push(String.valueOf(a + b));
            }
            else if(val.equals("D")){
                int a = 2*Integer.parseInt(String.valueOf(sk.peek()));
                sk.push(String.valueOf(a));
            }
            else if(val.equals("C") && sk.size() >= 1){
                sk.pop();
            }
            else {
                sk.push(val);
            }
        }
        int sum = 0;
        for(String val : sk){
            sum += Integer.parseInt(val);
        }
        return sum;
    }
}