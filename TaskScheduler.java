class Solution {

    class Data{
        int task;
        int time;
        public Data(int task, int time){
            this.task = task;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        Queue<Data> tq = new LinkedList();
        HashMap<Character, Integer> hm = new HashMap();
        for(char ch : tasks){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for(char ch : hm.keySet()){
            q.offer(hm.get(ch));
        }
        while(!tq.isEmpty() || !q.isEmpty()){
            if(!q.isEmpty()){
                int val = q.poll();
                val--;
                if(val != 0){
                    tq.offer(new Data(val,time + n));
                }
            }
            if(!tq.isEmpty() && tq.peek().time == time){
                q.offer(tq.poll().task);
            }
            time++;
        }
        return time;
    }
}