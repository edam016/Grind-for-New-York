class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            int num1 = 0;
            int num2 = 0;
            if(i >= 0){
                num1 = Integer.parseInt(String.valueOf(a.charAt(i)), 2);
            }
            if(j >= 0){
                num2 = Integer.parseInt(String.valueOf(b.charAt(j)), 2);
            }
            
            int sum = num1 + num2 + carry;
            if(sum == 0){
                sb.insert(0, 0);
                carry = 0;
            }
            if(sum == 1){
                sb.insert(0, 1);
                carry = 0;
            }
            if(sum == 2){
                sb.insert(0, 0);
                carry = 1;
            }
            if(sum == 3){
                sb.insert(0, 1);
                carry = 1;
            }
            i--;
            j--;
        }
        if(carry != 0){
            sb.insert(0, 1);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}