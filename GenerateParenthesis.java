class Solution {
    List<String> arr = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return arr;
    }

    public void dfs(String a, int closed, int open, int n){
        if(closed == n && open == n){
            arr.add(a);
        }
        String o = a + "(";
        String c = a + ")";
        if(open <= n){
            dfs(o, closed, open + 1, n);
            if(closed < open){
                dfs(c, closed + 1, open, n);
            }
        }
    }
}