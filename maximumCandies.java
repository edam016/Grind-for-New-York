class Solution {
    public int maximumCandies(int[] candies, long k) {
        long maxSize = Integer.MIN_VALUE;
        long maxCandies = Integer.MIN_VALUE;
        for(int i = 0;i<=candies.length-1;i++){
            maxSize = Math.max(candies[i], maxSize);
        }
        long left = 1, right = maxSize, middle= 0;
        while(left < right){
            middle = (left + right)/2;
            if(checkVal(candies, k, middle)){
                maxCandies = Math.max(maxCandies, middle);
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }
        return checkVal(candies, k, left) ? (int)left : (int)left - 1;
    }

    public boolean checkVal(int[] candies, long k, long size){
        long amount = 0;
        long piles = 0;
        long total = 0;
        for(int i = 0;i<=candies.length-1;i++){
            if(candies[i] >= size){
                piles = candies[i]/size;
                total += piles;
            }
        }

        return total >= k;
    }
}