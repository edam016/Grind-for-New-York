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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> arr){
        if(root == null){
            return;
        }
        dfs(root.left, arr);
        dfs(root.right, arr);
        arr.add(root.val);
    }
}