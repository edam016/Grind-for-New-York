class Solution {
    public int arrangeCoins(int n) {
        int row = 1;
        while(n > 0){
            if(row > n){
                break;
            }
            n -= row;
            row++;
        }
        return row-1;
    }
}