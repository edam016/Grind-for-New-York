class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> sk = new Stack();
        StringBuilder result = new StringBuilder();
        int count = 0;
        if(num.length() <= k){
            return "0";
        }
        for(char ch : num.toCharArray()){
            int val = ch - '0';
            if(sk.isEmpty() || sk.peek() < val){
                sk.push(val);
            }
            else{
                while(!sk.isEmpty() && count < k && sk.peek() > val){
                    sk.pop();
                    count++;
                }
                sk.push(val);
            }
        }
        while(count < k){
            sk.pop();
            count++;
        }
        for(int val : sk){
            result.append(String.valueOf(val));
        }
        while(result.toString().length() > 1 && result.toString().charAt(0) == '0'){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}