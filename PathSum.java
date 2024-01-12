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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    public boolean dfs(TreeNode root, int sum, int targetSum){
        if(root == null){
            return false;
        }
        sum += root.val;
        if(sum == targetSum && root.right == null && root.left == null){
            return true;
        }
        return dfs(root.left, sum, targetSum) || dfs(root.right, sum, targetSum);
    }
}