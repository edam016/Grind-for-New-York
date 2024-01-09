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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList();
        List<Integer> arr2 = new ArrayList();
        dfs(root1, arr1);
        dfs(root2, arr2);
        return arr1.equals(arr2);
    }

    public void dfs(TreeNode root, List<Integer> arr){
        if(root != null){
            if(root.left == null && root.right == null){
                arr.add(root.val);
                return;
            }
            dfs(root.left, arr);
            dfs(root.right, arr);
        }
    }
}