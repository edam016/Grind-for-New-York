class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length-1;
        int maxVal = Integer.MIN_VALUE;
        String [] letters = new String [removable.length];
        for(int i = 0;i<=removable.length-1;i++){
            letters[i] = (String.valueOf(s.charAt(removable[i])));
        }
    while(left < right){
            int middle = (left + right)/2;
            System.out.println(middle);
            if(testSub(s, p, middle, letters)){
                maxVal = Math.max(maxVal, middle);
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }
        return left;
    }

    public boolean testSub(String s, String p, int value, String[] letters){
        int j = 0;
        for(int i = 0;i<value;i++){
            s = s.replace(letters[i], "");
            System.out.println("letters:"+letters[i]);
        }

        System.out.println("s:"+s);
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