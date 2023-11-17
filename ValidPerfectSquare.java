class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num, middle = 0;
        double val = 0;
        if(num == 1){
            return true;
        }
        while(left < right){
            middle = (left + right)/2;
            val = Math.pow((double)middle, 2);
            if(val == num){
                return true;
            }
            if(val > num){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        return Math.pow(left, 2) == num;
    }
}