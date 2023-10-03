public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if (n == 0){
            return true;
        }
        for(int i = 0;i<=flowerbed.length-1;i++){
            if(flowerbed[i] == 0 && (i==flowerbed.length-1 || flowerbed[i+1] == 0) && (i==0||flowerbed[i-1] == 0)){
                flowerbed[i] = 1;
                count++;
            }
        }
        return n<=count;
    }
} {
    
}
