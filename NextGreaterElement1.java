class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] result = new int[nums1.length];
        Arrays.fill(result, -1);
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0;i<=nums1.length-1;i++){
            for(int j = 0;j<=nums2.length-1;j++){
                if(nums1[i] == nums2[j]){
                    hm.put(nums1[i], j);
                }
            }
        }
        for(int i = 0;i<=nums1.length-1;i++){
            for(int j = hm.get(nums1[i]) + 1;j<=nums2.length-1;j++){
                if(nums1[i] < nums2[j]){
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }
}