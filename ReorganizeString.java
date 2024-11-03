class Solution {
    class Data{
        int freq;
        int time;
        char ch;
        
        public Data(char ch, int freq, int time){
            this.ch = ch;
            this.freq = freq;
            this.time = time;
        }

        public Data(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String reorganizeString(String s) {
        HashMap<Character, Data> hm = new HashMap();
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        Queue<Data> tq = new LinkedList();
        StringBuilder sb = new StringBuilder();
        int sequence = 0;

        for(char ch : s.toCharArray()){
            if(hm.containsKey(ch)){
                Data data = hm.get(ch);
                hm.put(ch, new Data(ch, data.freq + 1));
            }else{
                Data data = new Data(ch, 1);
                hm.put(ch, data);
            }
        }

        for(char ch : hm.keySet()){
            pq.offer(hm.get(ch));
        }

        while(!pq.isEmpty() || !tq.isEmpty()){
            if(!pq.isEmpty()){
                Data data = pq.poll();
                int val = data.freq;
                val--;
                sb.append(data.ch);
                if(val > 0){
                    tq.offer(new Data(data.ch, val, sequence + 1));
                }
            }
            if(!tq.isEmpty() && tq.peek().time == sequence){
                pq.offer(tq.poll());
            }
            if(tq.size() > 0 && pq.size() == 0){
                return "";
            }
            sequence++;
        }

        return sb.toString();
    }
}