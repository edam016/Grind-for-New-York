class Solution {
    Stack<String> stck = new Stack<String>();
    public List<String> generateParenthesis(int n) {
        dfs("", n, 0, 0);
        return stck;
    }
    public void dfs(String s, int n, int open, int close){
        if(n == close && n == open){
            stck.push(s);
        }
        String o = s + "(";
        String c = s + ")";
        if(open <= n){
            dfs(o, n, open + 1, close);
            if(close < open){
                dfs(c, n, open, close + 1);
            }
        }
    }
}