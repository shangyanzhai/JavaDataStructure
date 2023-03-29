package Leetcode.DataStructrue.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 *  111   二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-depth-of-binary-tree
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

public class TheMinimumDepthOfBinaryTree {
    /**
    static class TreeNodeWithLevel {
        public TreeNode node;
        public int level;

        public TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    List<TreeNodeWithLevel> preorderOnlyLeaf(TreeNode root, int level) {
        List<TreeNodeWithLevel> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        if (root.left == null && root.right == null) {
            TreeNodeWithLevel nwl = new TreeNodeWithLevel(root, level);
            ans.add(nwl);
        }

        ans.addAll(preorderOnlyLeaf(root.left, level + 1));
        ans.addAll(preorderOnlyLeaf(root.right, level + 1));

        return ans;
    }

    public int minDepth(TreeNode root) {
        List<TreeNodeWithLevel> list = preorderOnlyLeaf(root, 1);
        TreeNodeWithLevel min = null;
        for (TreeNodeWithLevel nwl : list) {
            if (min == null || min.level > nwl.level) {
                min = nwl;
            }
        }

        if (min == null) { return 0; }
        return min.level;
    }
     */
    public int Depth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left != null && root.right != null ){
            int leftnum = 1;
            int rightnum = 1;
            if(root.left != null){
                leftnum = 1 + Depth(root.left);
            }
            if(root.right != null){
                rightnum = 1 + Depth(root.right);
            }
            return leftnum > rightnum ? rightnum : leftnum;
        }else if(root.left != null){
            return 1 + Depth(root.left);
        }else{
            return 1 + Depth(root.right);
        }

    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Depth(root);
    }
}
