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
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.freq, b.freq));
        HashMap<Integer, Data> hm = new HashMap();
        int[] result = new int[k];
        for(int i = 0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                Data data = hm.get(nums[i]);
                hm.put(nums[i], new Data(nums[i], data.freq + 1));
            }
            else{
                Data data = new Data(nums[i], 1);
                hm.put(nums[i], data);
            }
        }
        for(int val : hm.keySet()){
            pq.offer(hm.get(val));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int i = 0;
        while(!pq.isEmpty()){
            result[i++] = pq.poll().val;
        }
        return result;
    }
}