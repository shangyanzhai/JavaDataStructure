package Leetcode.DataStructrue.BinaryTree;

import java.util.*;

/**
 *     105  从前序与中序遍历序列构造二叉树
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 *  
 *
 * 示例 1:
 *
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *  
 *
 * 提示:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
public class PreorderAndInorderConstructBinaryTree {
    public TreeNode ListTobuildTree(List<Integer> preorderlist, List<Integer> inorderlist){
        //首先，由前序遍历可以知道二叉树的头节点是什么
        //在根据中序遍历，可以知查到头节点的位置，根据他的位置可以知道左子树的结点个数，与右子树的结点个数
        //但是，这有个前提，即头节点为独一无二的，只有如此才能保证在中序遍历中才能清楚左右子树的结点个数
        //设头节点在左子树中的leftVal位置
        //左子树 中序遍历 [0,leftVal - 1]
        //左子树 先序遍历 [1,leftVal]
        //右子树 中序遍历 [leftVal + 1,preorder.length]
        //右子树 先序遍历 [leftVal + 1,preorder.length]
        TreeNode root = new TreeNode();
        if(preorderlist.isEmpty()){
            return null;
        }

        int val = preorderlist.get(0);
        int leftval = inorderlist.indexOf(val);

        root.val = val;
        root.left = ListTobuildTree(preorderlist.subList(1,leftval + 1),inorderlist.subList(0,leftval));
        root.right = ListTobuildTree(preorderlist.subList(leftval + 1,preorderlist.size()),inorderlist.subList(leftval + 1, preorderlist.size()));

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //首先，由前序遍历可以知道二叉树的头节点是什么
        //在根据中序遍历，可以知查到头节点的位置，根据他的位置可以知道左子树的结点个数，与右子树的结点个数
        //但是，这有个前提，即头节点为独一无二的，只有如此才能保证在中序遍历中才能清楚左右子树的结点个数
        //设头节点在左子树中的leftVal位置
        //左子树 中序遍历 [0,leftVal - 1]
        //左子树 先序遍历 [1,leftVal]
        //右子树 中序遍历 [leftVal + 1,preorder.length]
        //右子树 先序遍历 [leftVal + 1,preorder.length]
        TreeNode root = new TreeNode();
        List<Integer> preorderlist = new ArrayList<>();
        List<Integer> inorderlist = new ArrayList<>();

        if(preorder.length != inorder.length){
            return root;
        }

        for(int i : preorder){
            preorderlist.add(i);
        }
        for(int i : inorder){
            inorderlist.add(i);
        }
        root = ListTobuildTree(preorderlist,inorderlist);
        return root;
    }
}
