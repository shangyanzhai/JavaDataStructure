package Leetcode.DataStructrue.BinaryTree;


import java.util.*;

/**
 *
 *  236. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class 二叉树的最近公共祖先_236 {
//    public boolean isSameTree(TreeNode root,TreeNode target){
//        if(root == null){
//            return false;
//        }
//        if(root == target){
//            return true;
//        }
//
//        if(isSameTree(root.left,target)){
//            return true;
//        }
//        return isSameTree(root.right,target);
//    }
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(p == root || q == root){
//            // System.out.println("2:" + root.val);
//            return root;
//        }
//        if(isSameTree(root.left,q) && isSameTree(root.left,p)){
//            // System.out.println("3:" + root.val);
//            return lowestCommonAncestor(root.left,p,q);
//        }
//        if(isSameTree(root.right,q) && isSameTree(root.right,p)){
//            return lowestCommonAncestor(root.right,p,q);
//        }
//
//        // System.out.println("1:" + root.val);
//
//        return root;
//    }
    //解法二
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ancestorListOfP = new ArrayList<>();
        List<TreeNode> ancestorListOfQ = new ArrayList<>();

        // 找到 p 和 q 的祖先列表
        TreeNode cur = root;
        TreeNode last = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            if (top.right == null || top.right == last) {
                if (top == p) {
                    ancestorListOfP.addAll(stack);
                } else if (top == q) {
                    ancestorListOfQ.addAll(stack);
                }

                stack.pop();
                last = top;
            } else {
                cur = top.right;
            }
        }

        if (ancestorListOfP.size() > ancestorListOfQ.size()) {
            int diff = ancestorListOfP.size() - ancestorListOfQ.size();
            for (int i = 0; i < diff; i++) {
                ancestorListOfP.remove(0);
            }
        } else if (ancestorListOfP.size() < ancestorListOfQ.size()) {
            int diff = ancestorListOfQ.size() - ancestorListOfP.size();
            for (int i = 0; i < diff; i++) {
                ancestorListOfQ.remove(0);
            }
        }

        for (int i = 0; i < ancestorListOfP.size(); i++) {
            TreeNode anP = ancestorListOfP.get(i);
            TreeNode anQ = ancestorListOfQ.get(i);
            if (anP == anQ) {
                return anP;
            }
        }

        // 理论不会走到这里
        return null;
    }
}
