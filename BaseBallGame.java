class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> sk = new Stack();
        for(int i = 0;i<=operations.length-1;i++){
            if(operations[i].equals("C")){
                sk.pop();
            }
            else if(operations[i].equals("D")){
                int val = sk.peek();
                int res = val * 2;
                sk.push(res);
            }
            else if(operations[i].equals("+")){
                int val = sk.pop();
                int val2 = sk.peek();
                sk.push(val);
                int res = val + val2;
                sk.push(res);
            }
            else{
                sk.push(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        for(int val : sk){
            sum += val;
        }
        return sum;
    }
}