public  class Solution {
    public int[] productExceptSelf(int[] nums) {
      int [] left = new int[nums.length];
      int [] right = new int[nums.length];
      int [] result = new int[nums.length];
      int total = 1;
      left[0] = 1;
      right[nums.length-1] = 1;
      for(int i = 1;i<nums.length;i++){
          total = total*nums[i-1];   
          left[i] = total; 
      }
      total = 1;
      int index = nums.length-2;
      for(int i = nums.length-1;i>=0;i--){
          if(index < 0){
              break;
          }
           total = total*nums[i];   
           right[index] = total;  
           index--;  
       }
      for(int i = 0;i<left.length;i++){
           result[i] = left[i]*right[i];
       }
      return result;
    }
}

ProductOfArrayExceptSelf {
    
}
