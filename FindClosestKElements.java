class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;
        List<Integer> res = new ArrayList();

        while(left < right){
            int middle = left + (right - left)/2;
            if(x <= arr[middle]){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }

        int lSide = left - 1;
        int rSide = left;
        while(res.size() < k){
            if(rSide == arr.length){
                res.add(arr[lSide]);
                lSide--;
            }
            else if(lSide < 0){
                res.add(arr[rSide]);
                rSide++;
            }
            else if(Math.abs(arr[lSide] - x) <= Math.abs(arr[rSide] - x)){
                res.add(arr[lSide]);
                lSide--;
            }
            else{
                res.add(arr[rSide]);
                rSide++;
            }
        }
        Collections.sort(res);
        return res;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        
        while(left < right){
            int middle = left + (right - left)/2;
            if(x <= arr[middle]){
                right = middle;
            }
            else if(x >= arr[middle + k]){
                left = middle + 1;
            }
            else if(Math.abs(arr[middle] - x) > Math.abs(arr[middle + k] - x)){
                left = middle + 1;
            }
            else{
                right = middle;
            }
        }
        List<Integer> res = new ArrayList();

        for(int i = left;i<left + k;i++){
            res.add(arr[i]);
        }
        return res;
    }
}