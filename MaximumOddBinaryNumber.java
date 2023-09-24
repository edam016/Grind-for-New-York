class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder leading = new StringBuilder();
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == '1'){
                ones++;
            }
        }
        if(ones == 1){
            for(int i = 0;i<=s.length()-1;i++){
                if(s.charAt(i) == '1'){
                    s = s.substring(0, i) + s.substring(i+1);
                    break;
                }
            }
            s = s + '1';
            return s;
        }
        else{
            while(count < (ones - 1)){
                leading.append("1");
                count++;
            }
            System.out.println(leading.toString());
            while(result.length() != (s.length() - leading.length()) - 1){
                result.append("0");
            }
            result.append("1");
            leading.append(result);
            return leading.toString();
        }
    }
}