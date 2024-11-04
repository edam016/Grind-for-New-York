class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        for(int num : piles){
            sum += num;
        }
        
        long left = 1;
        long right = sum;

        while(left < right){
            long middle = left + (right - left)/2;
            if(check(middle, piles, h)){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return (int)left;
    }

    public boolean check(long val, int[] piles, int h){
        
        long total = 0;
        for(int i = 0;i < piles.length;i++){
            total += piles[i]/val;
            if(piles[i] % val != 0){
                total++;
            }
        }

        return total <= h;
    }
}