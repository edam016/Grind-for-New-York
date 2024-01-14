class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] fArr = new int[101];
        int maxVal = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0;i<=nums.length-1;i++){
            fArr[nums[i]]++;
            maxVal = Math.max(maxVal, fArr[nums[i]]);
        }
        for(int i = 0;i<=fArr.length-1;i++){
            if(fArr[i] == maxVal){
                count+= fArr[i];
            }
        }
        return count;
    }
}