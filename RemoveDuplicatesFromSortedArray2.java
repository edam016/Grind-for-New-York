class Solution {
    public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums){
        if (i < 2 || n > nums[i - 2]){
            nums[i] = n;
            i++;
        }
    }
    return i;
    }

    public int removeDuplicates(int[] nums) {
        int val = nums[0];
        int count = 0;
        int result = nums.length;
        for(int i = 1;i<=result-1;i++){
            if(val == nums[i]){
                if(count >= 1){
                    for(int j = i;j<=nums.length-2;j++){
                        nums[j] = nums[j + 1];
                    }
                    i--;
                    result--;
                }
                else{
                    count++;
                }
            }
            else{
                val = nums[i];
                count = 0;
            }
        }
        return result;
    }
}