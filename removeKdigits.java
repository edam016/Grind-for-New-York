class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> sk = new Stack();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int count = k;

        if(num.length() == k){
            return "0";
        }

        while(index <= num.length()-1){
            if(sk.isEmpty()){
                sk.push(Integer.parseInt(String.valueOf(num.charAt(index))));
            }
            else if(!sk.isEmpty()){
                while(count > 0 && !sk.isEmpty() && sk.peek() > Integer.parseInt(String.valueOf(num.charAt(index)))){
                    sk.pop();
                    count--;
                }
                sk.push( Integer.parseInt(String.valueOf(num.charAt(index))));
            }
            index++;
        }
        while(count > 0){
            sk.pop();
            count--;
        }

        for(int val : sk){
            sb.append(val);
        }
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}