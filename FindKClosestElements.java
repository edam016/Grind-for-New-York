class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length-1;
        List<Integer> window = new ArrayList();
        while( r - l >= k){
            if(Math.abs(arr[l]-x) > Math.abs(arr[r]-x)){
                l++;//move left side as left is further as it is greater then r so increment l until l is k away from x
            }
            else{
                r--;
            }
        }
        for(int i = l;i<=r;i++){
            window.add(arr[i]);
        }
        return window;
    }
}