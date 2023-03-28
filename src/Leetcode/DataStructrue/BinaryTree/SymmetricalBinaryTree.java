package Leetcode.DataStructrue.BinaryTree;

/**
 * 101. 对称二叉树
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/symmetric-tree
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
public class SymmetricalBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return isTrue(root.left,root.right);
    }
    public boolean isTrue(TreeNode root1 , TreeNode root2){
        if(root1 == null && root2 == null){return true;}
        if(root1 == null || root2 == null){return false;}
        if(root1.val != root2.val){return false;}
        return isTrue(root1.left,root2.right) && isTrue(root1.right ,root2.left);
    }
}
