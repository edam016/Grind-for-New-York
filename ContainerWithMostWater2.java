class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxH = height[0];
        int maxV = 0;
        while(left < right){
            if(height[left] >= height[right]){
                maxH = height[right];
                right--;
            }
            else{
                maxH = height[left];
                left++;
            }
            maxV = Math.max(maxV, maxH * (right - left + 1));
        }
        return maxV;
    }
}