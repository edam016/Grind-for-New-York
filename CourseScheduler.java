class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> arr = new ArrayList();
        for(int i = 0;i<numCourses;i++){
            arr.add(new ArrayList());
        }
        for(int i =0;i<prerequisites.length;i++){
            arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(visited[i] == 0){
                if(dfs(arr, visited, i)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> arr, int[] visited, int cur){
        if(visited[cur] == 2){
            return true;
        }
        visited[cur] = 2;
        for(int i = 0;i<arr.get(cur).size();i++){
            if(visited[arr.get(cur).get(i)] != 1){
                if(dfs(arr, visited, arr.get(cur).get(i))){
                    return true;
                }
            }
        }
        visited[cur] = 1;
        return false;
    }
}