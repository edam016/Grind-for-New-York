class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
        
        - is a unidirectional graph
        - must learn cycle dtection
        - uses top sort -> DFS or BFS(Kahns algorithm)
        - Usage of adjacence list

         */

        //Building adjacency list here
         List<List<Integer>> adjList = new ArrayList<>();
         for(int i = 0;i<numCourses;i++){
            adjList.add(new ArrayList());
         }

         for(int[] prerequisite : prerequisites){
            adjList.get(prerequisite[1]).add(prerequisite[0]);
         }

         /**
         
        In this question, the adjacency list uses the following format of courses it is prereq for for instance [1, 0], [3,1], [3,2], [2,0] where you 
        need 0 to take 1 is as follow below

        [1, 2] Course 0
        [3] Course 1 
        [3] Course 2
        [] Course 3


        The point of the visited stack is to optimize/improve performance as it is able to recognize previously seen
        nodes in which we do not have to recalculate nodes for dfs traversal

        The recStack is used when dfs is initiated in which if the same node is seen in 1 dfs traversal, it suggests a cycle does in
        fact exist

          */

          //Initialize visit and recursion stack arrays  
          boolean[] visited = new boolean[numCourses]; //initialized to false
          boolean[] recStack = new boolean[numCourses];
        
       
          //Perform DFS
        for(int i = 0;i < numCourses;i++){
            if(!visited[i]){
                if(dfs(i, adjList, visited, recStack)){
                    return false; // Cycle detected
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] recStack){
        visited[node] = true;
        recStack[node] = true; //marking that the ith node has been in fact seen for this recrusive call

        for(int neighbor : adjList.get(node)){
            //neighbor is not reached yet
            if(!visited[neighbor]){
                if(dfs(neighbor, adjList, visited, recStack)){
                    return true;
                }
            }

            //Clarify what this portion means
            else if(recStack[neighbor]){
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }
}