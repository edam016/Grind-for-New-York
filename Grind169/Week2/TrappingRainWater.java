class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        int waterTrapped = 0;

        while(left < right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if(maxLeft > maxRight){
                if(height[right] < maxRight){
                    waterTrapped += (maxRight - height[right]);
                }
                right--;
            }
            else{
                if(height[left] < maxLeft){
                    waterTrapped += (maxLeft - height[left]);
                }
                left++;
            }
        }
        
        return waterTrapped;
    }
}