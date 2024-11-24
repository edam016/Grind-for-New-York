class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        /**
        
        Build adj list

         */


         Map<String, Set<String>> adj = new HashMap();

         for(List<String> account : accounts){
            String firstEmail = account.get(1);

            for(int i = 2;i<account.size();i++){
                String currentEmail = account.get(i);
                adj.computeIfAbsent(firstEmail, k -> new HashSet()).add(currentEmail);
                adj.computeIfAbsent(currentEmail, k -> new HashSet()).add(firstEmail);
            }
         }

         List<String> visited = new ArrayList();
         List<List<String>> result = new ArrayList();

         for(List<String> account : accounts){
            String email = account.get(1);
            if(visited.contains(email)){
                continue;
            }
            List<String> mergedArray = new ArrayList();
            dfs(email, visited, mergedArray, adj);
            if(mergedArray.size() > 1){
                Collections.sort(mergedArray);
            }
            mergedArray.add(0, account.get(0));
            result.add(mergedArray);
         }
         return result;
    }

    public void dfs(String email, List<String> visited, List<String> mergedArray, Map<String, Set<String>> adj){
        if(visited.contains(email)){
            return;
        }    
        mergedArray.add(email);
        visited.add(email);
        for(String nextEmail : adj.getOrDefault(email, Collections.emptySet())){
            dfs(nextEmail, visited, mergedArray, adj);
        }
    }
}