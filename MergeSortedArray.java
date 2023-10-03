class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        if(m == 0 && n == 0){
            return;
        }
        int[] res = new int[m+n];
        while(i < m && j < n){
            if(nums1[i] > nums2[j]){
                res[k++] = nums2[j++];
            }
            else{
                res[k++] = nums1[i++];
            }
        }
        while (i < m) {
            res[k++] = nums1[i++];
        }

        while (j < n) {
            res[k++] = nums2[j++];
        }
        for(int b = 0;b<=res.length-1;b++){
            nums1[b] = res[b];
        }
    }
}