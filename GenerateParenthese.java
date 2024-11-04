class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        HashSet<String> hs = new HashSet();
        backtrack(res, new StringBuilder(), hs, n, 0, 0);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder sb, HashSet<String> check, int n, int open, int close){
        if(open == n && close == n && check.add(sb.toString())){
            res.add(sb.toString());
            return;
        }
        if(!check.add(sb.toString())){
            return;
        }
        if(open > n || close > n){
            return;
        }
        for(int i = 0;i<n;i++){
            if(open < n){
                sb.append("(");
                backtrack(res, sb, check, n, open + 1, close);
                sb.deleteCharAt(sb.length()-1);
            }
            if(close < open){
                sb.append(")");
                backtrack(res, sb, check, n, open, close + 1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        backtrack(result, n, 0, 0, "");
        return result;
    }

    public void backtrack(List<String> result, int n, int open, int close, String s){
        if(open == n && close == n){
            result.add(s);
        }
        if(open < n){
            backtrack(result, n, open + 1, close, s + "(");
        }
        if(close < open){
            backtrack(result, n, open, close + 1, s + ")");
        }
    }
}