public @interface OAPractice {
    public class Solution(int[] items){
        Queue<Integer> q = new LinkedList();
        for(int val : items){
            q.offer(val);
        }
        while(!q.isEmpty()){
            int item = q.poll();
            
        }
    }
}
