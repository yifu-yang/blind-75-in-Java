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
    List<TreeNode> ans = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        return getK(root,k);
    }

    int getK(TreeNode root,int k){
        if(root==null){
            return -1;
        }
        if(root.left!=null){
            int n = getK(root.left,k);
            if(n>=0){
                return n;
            }
        }
        ans.add(root);
        if(ans.size()==k){
            return ans.get(k-1).val;
        }
        if(root.right!=null){
            int n = getK(root.right,k);
            if(n>=0){
                return n;
            }
        }
        return -1;
    }
}