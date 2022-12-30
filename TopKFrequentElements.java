public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int [] arr = new int[k];
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i], 1);
            }
        }
        int maxFound = 0;
        int maxKey = 0;
        // for(int i=0;i<k;i++){
        //     for(int m=0; m<nums.length;m++){
        //         if(hm.containsKey(nums[m]) && maxFound < hm.get(nums[m])){
        //             maxFound = hm.get(nums[m]);
        //             maxKey = nums[m];
        //         }
        //     }
        //     arr[i] = maxKey;
        //     hm.remove(maxKey);
        //     maxFound = 0;
        //     maxKey = 0;
        // }
        // return arr;
        //put values in array in which we save the number of occurences as the index and then iterate from end to start, k times using KeySet
        List<Integer> [] values = new ArrayList[nums.length + 1];
        for(int key : hm.keySet()){
            int value = hm.get(key);
            if(values[value] == null){
                values[value] = new ArrayList();
            }
            values[value].add(key);
        }
        for(int i = 0;i<values.length;i++){
            System.out.println(values[i]);
        }
        int m = 0;
        int i = values.length-1;
        while(m < k && i >= 0){
            if(values[i] != null){
                for(int s : values[i]){
                    arr[m] = s;
                    m++;
                }
            }
            i--;
        }
        return arr;
        
    }
};
