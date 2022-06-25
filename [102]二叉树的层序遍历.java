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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        List<TreeNode> top = new ArrayList<>();
        List<Integer> topAns = new ArrayList<>();
        List<TreeNode> down = new ArrayList<>();
        List<Integer> downAns = new ArrayList<>();
        top.add(root);
        topAns.add(root.val);
        while(top.size()!=0){
            for(TreeNode node : top){
                if(node.left!=null){
                    down.add(node.left);
                    downAns.add(node.left.val);
                }
                if(node.right!=null){
                    down.add(node.right);
                    downAns.add(node.right.val);
                }
            }
            ans.add(topAns);
            topAns = downAns;
            top =down ;
            down = new ArrayList<>();
            downAns = new ArrayList<>();
        }
        return ans;
    }
}