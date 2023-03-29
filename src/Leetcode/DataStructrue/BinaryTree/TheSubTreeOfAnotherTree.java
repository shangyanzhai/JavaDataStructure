package Leetcode.DataStructrue.BinaryTree;

/**
 *      572  另一棵树的子树
 *
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
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
public class TheSubTreeOfAnotherTree {
    public boolean isSame(TreeNode root,TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }

        if(root.val == subRoot.val){
            return isSame(root.left,subRoot.left) && isSame(root.right,subRoot.right);
        }else{
            return false;
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }

        if(root == null || subRoot == null){
            return false;
        }

        if(root.val == subRoot.val){
            if(isSame(root.left,subRoot.left) && isSame(root.right,subRoot.right)){
                return true;
            }
        }

        if(root.val != subRoot.val){
            if(root.left == null && root.right == null){
                return false;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    /** 方法二
    public boolean search(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            if (isSameTree(root, subRoot)) {
                return true;
            }
        }

        if (search(root.left, subRoot)) {
            return true;
        }

        return search(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
            && isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        return search(root, subRoot);
    }
    */

    // 方法三
    // public List<TreeNode> preorder(TreeNode root) {
    //     List<TreeNode> ans = new ArrayList<>();
    //     if (root == null) {
    //         return ans;
    //     }

    //     ans.add(root);
    //     ans.addAll(preorder(root.left));
    //     ans.addAll(preorder(root.right));

    //     return ans;
    // }

    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if (p == null && q == null) {
    //         return true;
    //     }

    //     if (p == null || q == null) {
    //         return false;
    //     }

    //     return p.val == q.val
    //         && isSameTree(p.left, q.left)
    //         && isSameTree(p.right, q.right);
    // }

    // public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    //     if (subRoot == null) {
    //         return true;
    //     }

    //     List<TreeNode> list = preorder(root);
    //     for (TreeNode node : list) {
    //         if (node.val == subRoot.val) {
    //             if (isSameTree(node, subRoot)) {
    //                 return true;
    //             }
    //         }
    //     }

    //     return false;
    // }
}
