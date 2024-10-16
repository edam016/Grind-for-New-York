class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long weight = mass;
        for(int i = 0;i<asteroids.length;i++){
            if(weight >= asteroids[i]){
                weight += asteroids[i];
            }
            else{
                return false;
            }
        }
        return true;
    }
}