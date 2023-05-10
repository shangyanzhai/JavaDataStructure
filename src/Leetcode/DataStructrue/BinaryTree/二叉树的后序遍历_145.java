package Leetcode.DataStructrue.BinaryTree;

import java.util.*;
/**
 * 145  二叉树的后序遍历
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.ArrayList;
import java.util.List;

public class 二叉树的后序遍历_145 {
    //递归
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     //后序遍历 ： 先遍历左子树，再遍历右子树 ，最后再遍历根结点

    //     List<Integer> list = new ArrayList<>();

    //     if(root == null){
    //         return list;
    //     }

    //     //先遍历左子树
    //     list.addAll(postorderTraversal(root.left));
    //     list.addAll(postorderTraversal(root.right));
    //     list.add(root.val);
    //     return list;
    // }

    /**
     // 非递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode last = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null) {
                stack.pop();
                list.add(top.val);

                last = top;
            } else if (top.right == last) {
                stack.pop();
                list.add(top.val);

                last = top;
            } else {
                // 说明是从 top 左边回来的
                cur = top.right;
            }
        }
        return list;
    }
    public static TreeNode buildTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;   n1.right = n3;
        n2.left = null; n2.right = null;    // 可以省略
        n3.left = n4;   n3.right = n5;
        n4.left = null; n4.right = null;
        n5.left = null; n5.right = null;

        return n1;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        二叉树的后序遍历_145 postOrderTraversal = new 二叉树的后序遍历_145();
        postOrderTraversal.postorderTraversal(root);

    }
}
