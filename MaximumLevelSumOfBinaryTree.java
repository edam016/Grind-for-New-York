/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int level = 0;
        int maxLevel = 0;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                sum += node.val;
            }
            if(maxSum < sum){
                maxSum = sum;
                maxLevel = level;
            }
            sum = 0;
        }
        return maxLevel;
    }
}