class Solution {
    class Data{
        double distance;
        double speed;

        public Data(double distance, double speed){
            this.distance = distance;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Data> sk = new Stack();
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b) ->Double.compare(a.distance, b.distance));
        double timePQ = 0;
        double timeSK = 0;
        for(int i = 0;i<position.length;i++){
            pq.offer(new Data(target - position[i], speed[i]));
        }
        for(int i = 0;i<position.length;i++){
            if(sk.isEmpty()){
                sk.push(pq.poll());
                continue;
            }
            timePQ = pq.peek().distance / pq.peek().speed;
            timeSK = sk.peek().distance / sk.peek().speed;
            if(!sk.isEmpty() && timePQ > timeSK){
                sk.push(pq.poll());
                continue;
            }
            pq.poll();
        }
        return sk.size();
    }
}