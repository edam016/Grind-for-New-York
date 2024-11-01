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
    public boolean isValidBST(TreeNode root) {
        long minVal = Long.MIN_VALUE;
        long maxVal = Long.MAX_VALUE;
        return dfs(root, minVal, maxVal);

    }

    public boolean dfs(TreeNode root, long minVal, long maxVal){
        if(root == null){
            return true;
        }
        else if(root.val <= minVal || root.val >= maxVal){
            return false;
        }
        return dfs(root.right, root.val, maxVal) && dfs(root.left, minVal, root.val);
    }
}