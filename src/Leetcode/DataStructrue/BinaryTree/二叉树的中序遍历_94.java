package Leetcode.DataStructrue.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**  94   二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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

class 二叉树的中序遍历_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        //此时，则需要判断根结点是否为空,如果根结点为空，则说明二叉树实际为空
        if(root == null){
            return list;
        }
        //因为中序遍历是先遍历左子树，然后是根结点，再然后是右子树。
        list.addAll(inorderTraversal(root.left));
        //走到此步，说明左子树为空
        //此时，则需要将根结点置入表中
        list.add(root.val);
        //下面需要判断右子树是否存在
        list.addAll(inorderTraversal(root.right));
        return list;
    }
    /**
     * public List<Integer> inorderTraversal(TreeNode root) {
     *         List<Integer> list = new ArrayList<>();
     *
     *         TreeNode cur = root;
     *         TreeNode last = null;
     *         Deque<TreeNode> stack = new LinkedList<>();
     *
     *         while(cur != null || !stack.isEmpty()){
     *             while(cur != null){
     *                 stack.push(cur);
     *                 cur = cur.left;
     *             }
     *
     *             TreeNode top = stack.pop();
     *             list.add(top.val);
     *
     *             if(top.right != null){
     *                 cur = top.right;
     *             }
     *         }
     *         return list;
     *     }
     */
}

