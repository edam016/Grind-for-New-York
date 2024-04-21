class Solution {

    class Data{
        int freq;
        int val;
        public Data(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }

    public int leastBricks(List<List<Integer>> wall) {
        PriorityQueue<Data> q = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0;i<=wall.size() - 1;i++){
            int sum = 0;
            for(int j = 0;j<=wall.get(i).size()-2;j++){
                sum += wall.get(i).get(j);
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        for(int val : hm.keySet()){
            q.offer(new Data(val, hm.get(val)));
        }
        if(hm.size() == 0){
            return wall.size();
        }
        System.out.println(hm.entrySet());
        return wall.size() - q.poll().freq;
    }
}