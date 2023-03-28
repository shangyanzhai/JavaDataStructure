package Leetcode.DataStructrue.BinaryTree;

/**
 * 144  二叉树的前序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

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
public class PreOrderTraversal {

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list1 = new ArrayList<>();
//        if(root == null){
//            return list1;
//        }
//        //前序遍历 首先访问根结点，然后访问左子树，再然后访问右子树
//        //走到这一步代表至少存在一个根结点
//        list1.add(root.val);
//
//        //再然后遍历左子树
//        list1.addAll(preorderTraversal(root.left));
//        list1.addAll(preorderTraversal(root.right));
//
//        return list1;
//    }
private List<Integer> resultList = new ArrayList<>();

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        resultList.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        resultList.clear(); // 确保结果集一开始是 empty
        preorder(root);
        return resultList;
    }
}

