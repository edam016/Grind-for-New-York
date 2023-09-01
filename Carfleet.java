class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int result = 0;
        double [] timeArr = new double [target];
        for(int i = 0;i<=position.length-1;i++){
            timeArr[position[i]] = (double)(target - position[i])/(speed[i]);
            System.out.println(timeArr[position[i]]);
        }
        double prev = 0.0;
        for(int i = target-1;i>=0;i--){
            double current = timeArr[i];
            
            if(current > prev){
                System.out.println(current);
                result++;
                prev = current;
            }
        }
        return result;
    }
}