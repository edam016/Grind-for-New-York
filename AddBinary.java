class Solution {
    public String addBinary(String a, String b) {
        //iterate through the strings doing binary addition
        int i = a.length()-1;
        int j = b.length() -1 ;
        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while( i>=0 || j >= 0 || carry != 0){
            sum = carry;
            if(i>=0){
                sum += Integer.parseInt(String.valueOf(a.charAt(i)));
            }
            if(j>=0){
                sum += Integer.parseInt(String.valueOf(b.charAt(j)));
            }
            int val = sum % 2;
            sb.insert(0, val);
            carry = sum / 2;
            i--;
            j--;
        }
        return sb.toString();
    }
}