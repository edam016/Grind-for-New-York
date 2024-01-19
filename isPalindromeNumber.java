class Solution {
    public boolean isPalindrome(int x) {
        List<Integer> arr = new ArrayList();
        if(x < 0){
            return false;
        }
        while(x > 9){
            arr.add(x%10);
            x /= 10;
        }
        arr.add(x);
        int l = 0, r = arr.size() - 1;
        while(l < r){
            if(arr.get(l) != arr.get(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}