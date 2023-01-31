class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int waterTrapped = 0;
        int maxLeft = height[left];
        int maxRight = height[right];
        while(left < right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if(maxLeft <= maxRight){
                left++;
                if((Math.min(maxLeft, maxRight) - height[left]) > 0){
                    waterTrapped += (Math.min(maxLeft, maxRight) - height[left]);
                }
            }
            else{
                right--;
                if((Math.min(maxLeft, maxRight) - height[right]) > 0){
                    waterTrapped += (Math.min(maxLeft, maxRight) - height[right]);
                }
            }
        }
        return waterTrapped;
    }
}