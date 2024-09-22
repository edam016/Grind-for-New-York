class Solution {
    class Data{
        int val;
        int freq;

        public Data(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Data> pq = new PriorityQueue<Data>((a,b) -> Integer.compare(a.freq, b.freq));
        HashMap<Integer, Data> hm = new HashMap();
        for(int num : nums){
            if(hm.containsKey(num)){
                int val = hm.get(num).freq;
                Data data = new Data(num, val + 1);
                hm.put(num, data);
            }
            else{
                Data data = new Data(num, 1);
                hm.put(num, data);
            }
        }
        for(int val : hm.keySet()){
            pq.offer(hm.get(val));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll().val;
            i++;
        }
        return res;
    }
}