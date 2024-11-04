class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxSize = 0;
        int size = 0;
        while(left < right){
            if(height[left] < height[right]){
                size = (right - left)*height[left];
                left++;
            }
            else{
                size = (right - left)*height[right];
                right--;
            }
            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }
}