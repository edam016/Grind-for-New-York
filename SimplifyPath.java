class Solution {
    public String simplifyPath(String path) {
        Stack<String> sk = new Stack<>();
        String[] arr = path.split("/");
        for (String val : arr){
            if(val.equals(".") || val.isEmpty()){
                continue;
            }
            if(val.equals("..")){
                if(!sk.isEmpty()) {
                    sk.pop();
                }
            }
            else{
                sk.push(val);
            }
        }
        return "/" + String.join("/", sk);
    }
}