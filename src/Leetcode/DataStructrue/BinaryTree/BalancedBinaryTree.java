package Leetcode.DataStructrue.BinaryTree;

/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：root = []
 * 输出：true
 *  
 *
 * 提示：
 *
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/balanced-binary-tree
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

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }

        //此时则代表该二叉树存在，且至少存在一个左子树 或者 右子树
        //当只存在一个左子树，右子树不存在的时候
        if(root.left != null && root.right == null){
            if(root.left.left != null || root.left.right != null){
                return false;
            }
            return true;
        }

        //当只存在一个左子树，右子树不存在的时候
        if(root.right != null && root.left == null){
            if(root.right.left != null || root.right.right != null){
                return false;
            }
            return true;
        }

        //此时左右子树都存在
        if(root.left != null && root.right == null){
            if(!isBalanced(root.left) || !isBalanced(root.right)){
                return false;
            }
        }
        return true;
    }
}
