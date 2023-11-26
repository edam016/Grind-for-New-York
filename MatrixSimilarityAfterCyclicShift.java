class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int[][] comp = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            comp[i] = Arrays.copyOf(mat[i], mat[i].length);
        }
        int rotations = k;
        while(rotations > 0){
            
            for(int i = 0;i<=comp.length-1;i++){
                int lastElem = comp[i][comp[0].length-1];
                int firstElem = comp[i][0];
                if(i%2 == 0){
                    for(int j = 0;j<=comp[0].length-2;j++){
                        comp[i][j] = comp[i][j + 1]; 
                    }
                    comp[i][comp[i].length-1] = firstElem;
                }
                else{
                    for(int j = comp[0].length-1;j>= 1;j--){
                        comp[i][j] = comp[i][j - 1];
                    }
                    comp[i][0] = lastElem;
                }
            }
            rotations--;
        }
        for(int i = 0;i<=comp.length-1;i++){
            for(int j = 0;j<=comp[i].length-1;j++){
                if(comp[i][j] != mat[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}