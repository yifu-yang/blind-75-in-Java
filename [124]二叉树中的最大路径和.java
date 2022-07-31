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
    int max= -1001;
    public int maxPathSum(TreeNode root) {
        int left = -1001;
        if(root.left!=null){
            left = max(root.left);
        }
        int right = -1001;
        if(root.right!=null){
            right = max(root.right);
        }
        return Math.max(max,Math.max(root.val,Math.max(left+right+root.val,Math.max(left+root.val,right+root.val))));
    }

    int max(TreeNode root){
        int left = -1001;
        if(root.left!=null){
            left = max(root.left);
        }
        int right = -1001;
        if(root.right!=null){
            right = max(root.right);
        }
        max = Math.max(max,Math.max(root.val,Math.max(left+right+root.val,Math.max(left+root.val,right+root.val))));
        return Math.max(root.val,Math.max(left+root.val,right+root.val));
    }
}