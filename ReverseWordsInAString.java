class Solution {
    public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    String [] words = s.split(" ");
    for(int i = 0;i<=words.length-1;i++){
        System.out.println(words[i]);
    }
    for(int i =0;i<=words.length-1;i++){
        if(!words[i].isEmpty()){
            sb.insert(0, words[i]);
            if(i<words.length-1){
                sb.insert(0, " ");
            }
        }
    }   
    return sb.toString();
    }
}