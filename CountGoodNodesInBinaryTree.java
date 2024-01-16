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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        dfs(root, root.val);
        return count;
    }

    public void dfs(TreeNode root, int maxVal){
        if(root == null){
            return;
        }
        int val = Math.max(maxVal, root.val);
        if(root.val >= val){
            count++;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }
}