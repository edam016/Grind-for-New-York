class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> hm = new HashMap();

        for(int i = 0;i<times.length;i++){
            int src = times[i][0];
            int target = times[i][1];
            int weight = times[i][2];
            hm.putIfAbsent(src, new ArrayList<int[]>());
            hm.get(src).add(new int[]{target, weight});
        }

        HashSet<Integer> visited = new HashSet();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

        int result = 0;

        pq.offer(new int[]{k, 0});
        //k is the source node and 0 is the inital starting weight to its neighbors

        while(!pq.isEmpty()){
            int[] next = pq.poll();
            int src = next[0];
            int weight = next[1];
            if(visited.contains(src)){
                continue;
            }
            result = weight;
            visited.add(src);
            if(!hm.containsKey(src)){
                continue;
            }
            for(int[] edge : hm.get(src)){
                int targSrc = edge[0];
                int targWeight = edge[1];
                pq.offer(new int[]{targSrc, targWeight + weight});
            }
        }

        return visited.size() == n ? result : -1;
    }
}