//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1642 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        List<Integer> leftIn = new ArrayList<>();
        List<Integer> rightIn = new ArrayList<>();
        List<Integer> leftPre = new ArrayList<>();
        List<Integer> rightPre = new ArrayList<>();
        boolean flag = false;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                flag = true;
                continue;
            }
            if(!flag){
                leftIn.add(inorder[i]);
            }else{
                rightIn.add(inorder[i]);
            }
        }
        for(int i=1;i<preorder.length;i++){
            if(leftPre.size()<leftIn.size()){
                leftPre.add(preorder[i]);
            }else{
                rightPre.add(preorder[i]);
            }
        }
        if(leftIn.size()!=0){
            root.left = buildTree(leftPre.stream().mapToInt(i->i).toArray(),leftIn.stream().mapToInt(i->i).toArray());
        }
        if(rightIn.size()!=0){
            root.right = buildTree(rightPre.stream().mapToInt(i->i).toArray(),rightIn.stream().mapToInt(i->i).toArray());
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
