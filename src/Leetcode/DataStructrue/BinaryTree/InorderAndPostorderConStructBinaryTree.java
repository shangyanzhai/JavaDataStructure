package Leetcode.DataStructrue.BinaryTree;
/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 *  
 *
 * 示例 1:
 *
 *
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 *  
 *
 * 提示:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;
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
public class InorderAndPostorderConStructBinaryTree {

    public List<Integer> arrayToList(int[] array){
        List<Integer> list = new ArrayList<>();
        for(int e : array){
            list.add(e);
        }
        return list;
    }

    public TreeNode listToTreeNode(List<Integer> inorderlist,List<Integer> postorlist){
        if(inorderlist.isEmpty()){
            return null;
        }
        //中序遍历和后序遍历，首先先切下标
        //由后序遍历的最后一个数，得到根结点 ，再然后在中序遍历中寻找
        //设，根结点再中序遍历的 leftSize 位置
        //则左子树有 leftSzie - 1
        //左子树的中序遍历就是 [0,0 + leftSize)
        //左子树的后序遍历就是 [0,0 + leftSize)
        //右子树的中序遍历就是 [leftSzie + 1,size)
        //右子树的后序遍历就是 [leftSzie,size - 1)
        TreeNode root = new TreeNode();
        //首先先找根结点
        int num = postorlist.get(postorlist.size() - 1);
        root = new TreeNode(num);
        int leftSize = inorderlist.indexOf(num);

        //切割左子树的中序 和 后序遍历
        List<Integer> leftin = inorderlist.subList(0,leftSize);
        List<Integer> leftpost = postorlist.subList(0,leftSize);
        root.left = listToTreeNode(leftin,leftpost);
        //切割右子树的中序 和 后序遍历
        List<Integer> rightin = inorderlist.subList(leftSize + 1,inorderlist.size());
        List<Integer> rightpost = postorlist.subList(leftSize ,inorderlist.size() - 1);
        root.right = listToTreeNode(rightin ,rightpost);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inorderlist = arrayToList(inorder);
        List<Integer> postorderlist = arrayToList(postorder);

        return listToTreeNode(inorderlist,postorderlist);
    }
}
