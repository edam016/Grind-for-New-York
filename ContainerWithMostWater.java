public class ContainerWithMostWater {
        public int maxArea(int[] height) {
            int maxWater = 0;
            int start = 0;
            int end = height.length-1;
            int distance = height.length-1;
            if(height.length == 0){
                return 0;
            }
            while(start < end){
                int total = Math.min(height[start], height[end]);
                if((total * distance) > maxWater){
                    maxWater = total*distance;
                }
                else if(height[start] > height[end]){
                    end--;
                    distance--;
                }
                else if(height[end] >= height[start]){
                    start++;
                    distance--;
                }
            }
            return maxWater;
        }
}
