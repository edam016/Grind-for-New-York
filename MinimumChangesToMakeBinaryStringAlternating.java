class Solution {
    public int minOperations(String s) {
        StringBuilder case1 = new StringBuilder();
        StringBuilder case2 = new StringBuilder();
        String seq = "";
        for(int i = 0;i<=s.length()-1;i++){
            if(i%2 == 0){
                case1.append(0);
                case2.append(1);
            }
            else{
                case1.append(1);
                case2.append(0);
            }
        }
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i<=case1.length()-1;i++){
            if(case1.toString().charAt(i) != s.charAt(i)){
                count1++;
            }
            if(case2.toString().charAt(i) != s.charAt(i)){
                count2++;
            }
        }
        return Math.min(count1, count2);
    }
}