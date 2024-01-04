class Solution {
   public int minOperations(int[] nums) {
       HashMap<Integer, Integer> hm = new HashMap();
       int sum = 0;
       for(int i = 0;i<=nums.length-1;i++){
           if(hm.containsKey(nums[i])){
               hm.put(nums[i], hm.get(nums[i]) + 1);
           }
           else{
               hm.put(nums[i], 1);
           }
       }
        System.out.println(hm.entrySet());
       for(int val : hm.keySet()){
            if(hm.get(val)  == 1){
               return -1;
            }
            if(hm.get(val) % 3 == 0){
                sum += hm.get(val)/3;
            }
            else if(hm.get(val) %3 == 1 || hm.get(val) %3 == 2){
               sum += (hm.get(val)/3) + 1;
            }
            else if(hm.get(val) % 2 == 0){
               sum += hm.get(val)/2;
            }
        }
       return sum;
   }
}