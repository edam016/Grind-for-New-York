class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> hm = new HashMap();

        for(int[] flight : flights){
            int source = flight[0];
            int targ = flight[1];
            int weight = flight[2];
            hm.putIfAbsent(source, new ArrayList<int[]>());
            hm.get(source).add(new int[]{targ, weight});
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{src, 0, 0});
        //source, weight, stops

        while(!q.isEmpty()){
            int[] next = q.poll();
            int curr = next[0];
            int weight = next[1];
            int stop = next[2];
            if(!hm.containsKey(curr)){
                continue;
            }
            if(stop > k){
                continue;
            }
            for(int[] neighbor : hm.get(curr)){
                int node = neighbor[0];
                int price = neighbor[1];
                if(minCost[node] < price + weight){
                    continue;
                }
                minCost[node] = price + weight;
                q.offer(new int[]{node, minCost[node], stop + 1});
            }
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}