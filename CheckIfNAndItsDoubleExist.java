class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0;i<=arr.length-1;i++){
            if(hm.containsKey(arr[i])){
                return true;
            }
            else{
                hm.put(arr[i]*2, 1);
                if(arr[i]%2 == 0){ // check value is not odd as you cant have a half of an odd number
                    hm.put(arr[i]/2, 1);
                }
            }
        }
        return false;
    }
}