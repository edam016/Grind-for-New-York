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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList();
        dfs(arr, root);
        return arr;
    }

    public void dfs(List<Integer> arr, TreeNode root){
        if(root == null){
            return;
        }
        dfs(arr, root.left);
        arr.add(root.val);
        dfs(arr, root.right);
    }
}