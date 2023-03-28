package Leetcode.DataStructrue.BinaryTree;

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


import jdk.nashorn.internal.ir.Node;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        //后序遍历 ： 先遍历左子树，再遍历右子树 ，最后再遍历根结点

        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        //先遍历左子树
        list.addAll(postorderTraversal(root.left));

        list.addAll(postorderTraversal(root.right));

        list.add(root.val);

        return list;
    }
}
