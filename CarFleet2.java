class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> sk = new Stack();
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0;i<=position.length-1;i++){
            hm.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        for(int i = 0;i<=position.length-1;i++){
            double val = calcT(position[i], hm.get(position[i]), target);
            if(sk.isEmpty()){
                sk.push(val);
            }
            else if(!sk.isEmpty() && sk.peek() < val){
                while(!sk.isEmpty() && sk.peek() < val){
                    sk.pop();
                }
                sk.push(val);
            }
            else if(!sk.isEmpty() && sk.peek() > val){
                sk.push(val);
            }
        }
        return sk.size();
    }

    public double calcT(int position, int speed, int target){
        return (double)(target - position)/speed;
    }
}