class Solution {
    public String ContinuousSubArray(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, -1);
        int total = 0;
        for(int i = 0;i<nums.length;i++){
            total += nums[i];
            if(hm.containsKey(total%k)){
                if(i - hm.get(total%k) > 1){
                    return true;
                }
            }
            else{
                hm.put(total%k, i);
            }
        }
        /*
        
        Checking with the total%k, if the sum can be achieved by removing the first half elements sum to find the subsequence
        In the test case below, 14 is achieved by adding 5 + 9 but the total is 16, however at each step we are seeing what first half elements we can remove to form the subsequence
        as that subsequence if the total%k is found then total - first half sum is equal to the target sum

        */ 
        return false;
    }
}

/*
 * 
 * Test Case: [2,5,9,3] k = 14
 * 
 * hm = [2, 0], [7, 1], [9, 2]
 * tot = 2, 7, 16, 
 * 
 */