class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> sk = new Stack<Integer>();

        for(int i = 0;i<=asteroids.length-1;i++){
            if(asteroids[i] < 0){
                while(!sk.isEmpty() && asteroids[i] < 0 && Math.abs(asteroids[i]) > sk.peek() && sk.peek() > 0){
                    sk.pop();
                }
                if(!sk.isEmpty() && sk.peek() == Math.abs(asteroids[i]) && sk.peek() > 0){
                    sk.pop();
                }
                else if(sk.isEmpty() || sk.peek() < 0){
                    sk.push(asteroids[i]);
                }
            }
            else{
                sk.push(asteroids[i]);
            }
        }
        int [] arr = new int[sk.size()];
        int i = 0;
        for(int val : sk){
            arr[i] = val;
            i++;
        }
        return arr;
    }
}