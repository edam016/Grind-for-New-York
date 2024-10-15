class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList();
        backtrack(n, 0, 0, arr, "");
        return arr;
    }

    public void backtrack(int n, int open, int  close, List<String> arr, String str){
        if(close == n && open == n){
            arr.add(str);
            return;
        }
        if(open < n){
            backtrack(n, open + 1, close, arr, str + "(");
        }
        if(close < open){
            backtrack(n, open, close + 1, arr, str + ")");
        }
    }
}