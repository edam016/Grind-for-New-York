class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for(int i = 0;i<=piles.length-1;i++){
            right = Math.max(piles[i], right);
        }
        while(left < right){
            int middle = left + (right - left) / 2;
            int hours = 0;
            for(int pile : piles){
                hours += pile/middle;
                if(pile % middle != 0){
                    hours++;
                }
            }
            if(hours<=h){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return left;
    }
}