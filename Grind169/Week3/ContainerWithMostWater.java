class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while(left < right){
            if(height[left] > height[right]){
                maxWater = Math.max(height[right] * (right - left), maxWater);
                right--;
            }
            else{
                maxWater = Math.max(height[left] * (right - left), maxWater);
                left++;
            }
        }
        return maxWater;
    }
}