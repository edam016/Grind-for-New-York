class Solution {
    public String simplifyPath(String path) {
        Stack<String> sk = new Stack();
        String[] parts = path.split("/");

        for(int i = 0;i<parts.length;i++){
            if(parts[i].equals("") || parts[i].equals(".")){
                continue;
            }
            else if(parts[i].equals("..")){
                if(!sk.isEmpty()){
                    sk.pop();
                }
            }
            else{
                sk.push(parts[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String dir : sk){
            sb.append("/"+dir);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}