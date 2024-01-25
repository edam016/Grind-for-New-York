class Solution{
    public int[] findOrder(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> adjList = new HashMap();
        int[] indegree = new int[numCourses];
        int[] topSort = new int[numCourses];

        for(int i = 0;i<numCourses;i++){
            adjList.put(i, new ArrayList());
        }

        for(int i = 0;i<prerequisites.length;i++){
            List<Integer> arr = adjList.get(prerequisites[i][1]);
            arr.add(prerequisites[i][0]);
            adjList.put(prerequisites[i][1], arr);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int i = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            topologicalSort[i++] = node;
            if(adjList.containsKey(node)){
                for(int neighbor : adjList.get(node)){
                    indegree[neighbor]--;
                    if(indegreep[neighbor] == 0){
                        q.add(neighbor);
                    }
                }
            }
        }
        if(i == numCourses){
            return topologicalSort;
        }
        return new int[0];
    }
}