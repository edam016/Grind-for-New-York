class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length-1;
        int maxVal = Integer.MIN_VALUE;
        String [] letters = new String [removable.length];
        while(left < right){
            int middle = (left + right)/2;
            if(testSub(s, p, middle, removable)){
                maxVal = Math.max(maxVal, middle);
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }
        if(testSub(s, p, left, removable)) return left + 1;
        return maxVal + 1 >= 0 ? maxVal + 1: 0;
    }

    public boolean testSub(String s, String p, int value, int[] removable){
        int j = 0;
        String[] word = new String[s.length()];
        for(int i = 0;i<=s.length()-1;i++){
            word[i] = String.valueOf(s.charAt(i));
        }
        for(int i = 0;i<=value;i++){
            word[removable[i]] = "";
        }
        s = String.join("", word);
        System.out.println(s);
        System.out.println(p);
        for(int i = 0;i<=s.length()-1;i++){
            if(s.charAt(i) == p.charAt(j)){
                j++;
            }
            if(j == p.length()){
                System.out.println("value:"+value);
                return true;
            }
        }
        return false;
    }
}