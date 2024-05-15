class Solution {
    public String pushDominoes(String dominoes) {
        int [] forceArr = new int [dominoes.length()];
        int force = 0;
        for(int i = 0;i<dominoes.length();i++){
            if(dominoes.charAt(i) == 'R'){
                force = dominoes.length();
            }
            else if(dominoes.charAt(i) == 'L'){
                force = 0;
            }
            else{
                force = Math.max(force - 1, 0);
            }
            forceArr[i] += force;
        }

        for(int i = dominoes.length()-1;i>=0;i--){
            if(dominoes.charAt(i) == 'L'){
                force = dominoes.length();
            }
            else if(dominoes.charAt(i) == 'R'){
                force = 0;
            }
            else{
                force = Math.max(force - 1, 0);
            }
            forceArr[i] -= force;
        }

        StringBuilder sb = new StringBuilder();

        for(int val : forceArr){
            if(val > 0){
                sb.append('R');
            }
            else if(val < 0){
                sb.append('L');
            }
            else{
                sb.append('.');
            }
        }
        return sb.toString();
    }
}