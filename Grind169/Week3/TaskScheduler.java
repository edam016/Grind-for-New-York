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
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        Queue<Data> timeq = new LinkedList();
        int[] fMap = new int[26];
        int count = 0;

        for(char task : tasks){
            fMap[Character.toLowerCase(task) - 'a']++;
        }

        for(int freq : fMap){
            if(freq > 0){
                pq.offer(freq);
            }
        }

        while(!pq.isEmpty() || !timeq.isEmpty()){
            if(!pq.isEmpty()){
                int freq = pq.poll();
                if(freq > 1){
                    timeq.offer(new Data(freq - 1, count + n));
                }
            }
            if(!timeq.isEmpty()){
                if(timeq.peek().time == count){
                    Data data = timeq.poll();
                    pq.offer(data.freq);
                }
            }
            count++;
        }

        return count;
    }
}