class Solution {
    public int countComponents(int n, int[][] edges) {
        
        HashMap<Integer, Set<Integer>> adj = new HashMap();

        for(int[] edge : edges){
            adj.computeIfAbsent(edge[0], k-> new HashSet()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k-> new HashSet()).add(edge[0]);
        }

        List<Integer> visited = new ArrayList();
        List<List<Integer>> result = new ArrayList();

        for(int[] edge : edges){
            if(visited.contains(edge[0])){
                continue;
            }
            List<Integer> connected = new ArrayList();
            dfs(edges, adj, connected, visited, edge[0]);
            result.add(connected);
        }

        int unconnected = 0;

        for(int i = 0;i<n;i++){
            if(!adj.containsKey(i)){
                unconnected++;
            }
        }
        return result.size() + unconnected;
    }

    public void dfs(int[][] edges, HashMap<Integer, Set<Integer>> adj, List<Integer> connected, List<Integer> visited, int edge){
        if(visited.contains(edge)){
            return;
        }
        visited.add(edge);
        connected.add(edge);

        for(int next : adj.getOrDefault(edge, Collections.emptySet())){
            dfs(edges, adj, connected, visited, next);
        }
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        
        HashMap<Integer, Set<Integer>> adj = new HashMap();

        for(int[] edge : edges){
            adj.computeIfAbsent(edge[0], k-> new HashSet()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k-> new HashSet()).add(edge[0]);
        }

        Set<Integer> visited = new HashSet();
        List<List<Integer>> result = new ArrayList();
        int connected = 0;
        for(int i = 0; i<n;i++){
            if(!visited.contains(i)){
                dfs(adj, visited, i);
                connected++;
            }
        }

        return connected;
    }

    public void dfs(HashMap<Integer, Set<Integer>> adj, Set<Integer> visited, int node){
        visited.add(node);
        for(int next : adj.getOrDefault(node, Collections.emptySet())){
            if(!visited.contains(next)){
                dfs(adj, visited, next);
            }
        }
    }
}