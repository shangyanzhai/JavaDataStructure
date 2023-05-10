package Leetcode.DataStructrue.BinaryTree;
import java.util.*;
/**
 *      102. 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal
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
public class 二叉树的层序遍历_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> leverlist = new ArrayList<>();

        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> leverqueue = new LinkedList<>();
        int last = 0;
        queue.offer(root);
        leverqueue.offer(0);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int lever = leverqueue.poll();

            if(last == lever){
                leverlist.add(node.val);
            }else{
                list.add(leverlist);
                last = lever;
                leverlist = new ArrayList<>();
                leverlist.add(node.val);
            }

            if(node.left != null){
                queue.offer(node.left);
                leverqueue.offer(lever + 1);
            }

            if(node.right != null){
                queue.offer(node.right);
                leverqueue.offer(lever + 1);
            }
        }
        list.add(leverlist);
        return list;
    }
}
