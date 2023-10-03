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
            public int maxArea(int[] height) {
                int l = 0, r = height.length-1, max = 0, h = 0;
                while(l < r){
                    h = Math.min(height[l], height[r]);
                    max = Math.max(h * (r - l), max);
                    if(height[l] > height[r]){
                        r--;
                    }
                    else{
                        l++;
                    }
                }
                return max;
            }
}
