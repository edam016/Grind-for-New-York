class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hs1 = new HashMap();
        HashMap<Integer, Integer > hs2 = new HashMap();

        List<List<Integer>> res = new ArrayList();
        for(int i = 0;i<=nums1.length-1;i++){
            hs1.put(nums1[i], 1);
        }
        for(int i = 0;i<=nums2.length-1;i++){
            hs2.put(nums2[i], 1);
        }
        
        for(int i = 0;i<=nums2.length-1;i++){
            if(hs1.containsKey(nums2[i])){
                hs1.remove(nums2[i]);
            }
        }
        for(int i = 0;i<=nums1.length-1;i++){
            if(hs2.containsKey(nums1[i])){
                hs2.remove(nums1[i]);
            }
        }

        List<Integer> arr1 = new ArrayList(hs1.keySet());
        List<Integer> arr2 = new ArrayList(hs2.keySet());
        res.add(arr1);
        res.add(arr2);
        return res;
    }
}