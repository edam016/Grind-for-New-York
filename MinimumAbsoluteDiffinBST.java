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
    List<Integer> arr;
    public int minDiffInBST(TreeNode root) {
        arr = new ArrayList();
        int result = Integer.MAX_VALUE;
        dfs(root);
        for(int i = 0;i<=arr.size()-2;i++){
            result = Math.min(Math.abs(arr.get(i) - arr.get(i + 1)), result);
        }
        return result;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        arr.add(root.val);
        dfs(root.right);
    }
}