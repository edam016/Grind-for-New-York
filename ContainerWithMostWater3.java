class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxVolume = Integer.MIN_VALUE;
        while(left < right){
            if(height[left] > height[right]){
                maxVolume = Math.max(height[right] * (right - left), maxVolume);
                right--;
            }
            else{
                maxVolume = Math.max(height[left] * (right - left), maxVolume);
                left++;
            }
        }
        return maxVolume;
    }
}