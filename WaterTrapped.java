class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;

        int maxRight = height[right];
        int maxLeft = height[left];

        int waterTrapped = 0;

        while(left < right){
            maxRight = Math.max(maxRight, height[right]);
            maxLeft = Math.max(maxLeft, height[left]);

            if(maxLeft <= maxRight){
                if(height[left] < maxLeft){
                    waterTrapped += maxLeft- height[left];
                }
                left++;
            }
            else{
                if(height[right] < maxRight){
                    waterTrapped += maxRight - height[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }
}