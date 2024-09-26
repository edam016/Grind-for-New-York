class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> hm = new HashMap();
        HashMap<Integer, Integer> hm2 = new HashMap();
        int sum = 0;
        int minOps = Integer.MAX_VALUE;

        for(int i = 0;i<nums.length;i++){
            int index = nums.length-1 - i;
            sum += nums[index];
            hm.put(sum, i + 1);
        }
        sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            hm2.put(sum, i + 1);
        }
        sum = 0;
        for(int i = -1;i<nums.length;i++){
            if(i == -1){
                if(hm.containsKey(x)){
                    minOps = Math.min(minOps, hm.get(x));
                }
                continue;
            }
            sum += nums[i];
            if(hm.containsKey(x - sum) && i < nums.length - hm.get(x - sum)){
                minOps = Math.min(hm.get(x - sum) + i + 1, minOps);
            }
        }
        sum = 0;
        for(int i = nums.length-1;i>=0;i--){
            if(i == nums.length - 1){
                if(hm2.containsKey(x)){
                    minOps = Math.min(minOps, hm2.get(x));
                }
                continue;
            }
            sum += nums[i];
            if(hm2.containsKey(x - sum) && i > hm2.get(x - sum) - 1){
                minOps = Math.min(hm2.get(x - sum) + (nums.length -i), minOps);
            }
        }

        return minOps == Integer.MAX_VALUE ? -1 : minOps;
    }
}

class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> hm = new HashMap();
        int sum = 0;
        int minOp = Integer.MAX_VALUE;
        for(int i = nums.length-1;i>=0;i--){
            sum += nums[i];
            hm.put(sum, nums.length - i);
        }
        sum = 0;
        if(hm.containsKey(x)){
            minOp = hm.get(x);
        }
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(sum == x){
                minOp = Math.min(minOp, i + 1);
            }
            if(hm.containsKey(x - sum)){
                if(i + 1 + hm.get(x - sum) < nums.length){
                    minOp = Math.min(minOp, hm.get(x - sum) + i + 1);
                }
            }
        }
        return minOp == Integer.MAX_VALUE ? -1 : minOp;
    }
}

class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> hm = new HashMap();
        int sum = 0;
        int minOps = Integer.MAX_VALUE;
        for(int i = nums.length-1;i>=0;i--){
            sum += nums[i];
            hm.put(sum, nums.length - i);
        }

        if(hm.containsKey(x)){
            minOps = hm.get(x);
        }
        sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(sum == x){
                minOps = Math.min(minOps, i + 1);
            }
            if(hm.containsKey(x - sum)){
                if(i + hm.get(x - sum) < nums.length){
                    minOps = Math.min(minOps, i + 1 + hm.get(x - sum));
                }
            }
        }
        return minOps == Integer.MAX_VALUE ? -1 : minOps;
    }
}