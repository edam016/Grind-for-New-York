class Solution {
    public String pushDominoes(String dominoes) {
        int[] left = new int[dominoes.length()];
        int[] right = new int[dominoes.length()];
        StringBuilder sb = new StringBuilder();
        int force = 0;
        for(int i = 0;i<dominoes.length();i++){
            if(dominoes.charAt(i) == 'R'){
                force = dominoes.length();
            }
            else if(dominoes.charAt(i) == '.'){
                if(force > 0){
                    force--;
                }
            }
            else{
                force = 0;
            }
            right[i] = force;
        }
        force = 0;
        for(int i = dominoes.length()-1;i>= 0;i--){
            if(dominoes.charAt(i) == 'L'){
                force = dominoes.length();
            }
            else if(dominoes.charAt(i) == '.'){
                if(force > 0){
                    force--;
                }
            }
            else{
                force = 0;
            }
            left[i] = force;
        }
        for(int i = 0;i<left.length;i++){
            if(left[i] > right[i]){
                sb.append('L');
            }
            else if(left[i] < right[i]){
                sb.append('R');
            }
            else{
                sb.append('.');
            }
        }
        return sb.toString();
    }
}