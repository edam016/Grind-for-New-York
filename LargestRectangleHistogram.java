class Solution {

    class Data{
        
        int val;
        int index;
        
        public Data(int val, int index){
            this.val = val;
            this.index = index;
        }

    }
    public int largestRectangleArea(int[] heights) {
        Stack<Data> sk = new Stack();
        int maxArea = 0;
        int newI = 0;
        for(int i = 0;i<heights.length;i++){
            newI = i;
            if(sk.isEmpty()){
                sk.push(new Data(heights[i], i));
                continue;
            }
            else if(!sk.isEmpty() && heights[i] < sk.peek().val){

                while(!sk.isEmpty() && heights[i] < sk.peek().val){
                    Data data = sk.pop();
                    newI = data.index;
                    maxArea = Math.max((i - data.index) * data.val, maxArea);
                }
            }
            sk.push(new Data(heights[i], newI));
        }
        while(!sk.isEmpty()){
            Data data = sk.pop();
            maxArea = Math.max((heights.length - data.index) * data.val, maxArea);
        }
        return maxArea;
    }
}