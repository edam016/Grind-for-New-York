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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length-1, nums);
    }

    public TreeNode dfs(int l, int r, int[] nums){
        if(l > r){
            return null;
        }
        int middle = (l + r)/2;
        TreeNode tree = new TreeNode(nums[middle]);
        tree.left = dfs(l, middle - 1, nums);
        tree.right = dfs(middle + 1, r, nums);
        return tree;
    }
}