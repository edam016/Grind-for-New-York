class Solution {
    public int minEatingSpeed(int[] piles, int h){
        long maxVal = Integer.MIN_VALUE;
        Arrays.sort(piles);
        for(int pile : piles){
            maxVal = Math.max(pile, maxVal);
        }
        long left = 1, right = maxVal;
        while(left < right){
            long middle = (left + right)/2;
            if(checkValue(piles, middle) <= h){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }

        return (int)left;
    }

    public int checkValue(int[] piles, long middle){
        int hours = 0;
        for(int pile : piles){
            hours += pile/middle; // number of times middle goes into pule
            if(pile % middle != 0){
                hours++;
                // whatever is left that doesnt make it to the next multiple is added here 
                // checked with modulo for remainders
            }
        }
        return hours;
    }
}