class Solution {

    class Data{
        int freq;
        int time;

        public Data(int freq, int time){
            this.freq = freq;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        if(n == 0){
            return tasks.length;
        }
        int time = 0;
        HashMap<Character, Integer> hm = new HashMap();

        for(char ch : tasks){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        Queue<Data> tq = new LinkedList();
        for(char ch : hm.keySet()){
            pq.offer(hm.get(ch));
        }

        while(!pq.isEmpty() || !tq.isEmpty()){
            int val = 0;
            if(!pq.isEmpty()){
                val = pq.poll();
                val--;
            }
            if(val > 0){
                tq.offer(new Data(val, time + n));
            }
            if(!tq.isEmpty() && tq.peek().time == time){
                pq.offer(tq.poll().freq);
            }
            time++;
        }

        return time;
    }
}