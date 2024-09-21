class Solution {
    public int minEatingSpeed(int[] piles, int h){
        long left = 1;
        long right = Arrays.stream(piles).asLongStream().sum();
        long mid = 0;

        while(left < right){
            mid = left + (right - left)/2;
            if(checkVal(piles, mid, h)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return (int)left;
    }

    public boolean checkVal(int[] piles, long num, int h){
        
        int count = 0;
        for(int val : piles){
            count += val/num;
            if(val % num != 0){
                count++;
            }
        }
        return count <= h;
    }
}