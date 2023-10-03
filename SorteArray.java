class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums, int low, int high){
        if(low < high){
            int middle = (high - low) / 2 + low;
            mergeSort(nums, low, middle);
            mergeSort(nums, middle + 1, high);
            merge(nums, low, middle, high);
        }
    }

    public void merge(int[] nums, int l, int m, int r){
        int n1 = m + 1 - l;
        int n2 = r - m;
        int []left = new int[n1];
        int []right = new int[n2];
        for(int i = 0;i<n1;i++){
            left[i] = nums[l+i];
        }
        for(int i = 0;i<n2;i++){
            right[i] = nums[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
                } 
            else {
                    nums[k++] = right[j++];
                }
            }

        while (i < n1) {
            nums[k++] = left[i++];
        }

        while (j < n2) {
            nums[k++] = right[j++];
        }
    }
}