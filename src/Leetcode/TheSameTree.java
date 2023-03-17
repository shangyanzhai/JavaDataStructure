package test.Leetcode;

/** 100   相同的树
 *
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 *
 *
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/same-tree
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

class TheSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode p1 = p;
        TreeNode q1 = q;
        //首先，如果其中一个二叉树为空，另一个不为空，则返回false
        if((p1 == null && q1 != null) || (p1 != null && q1 ==null)){
            return false;
        }
        if(p1 == null && q1 == null){
            return true;
        }
        //此时，可以判断出来，p 和 q 均不为空
        if(p1.val != q1.val){
            return false;
        }else{
            if(isSameTree(p1.left,q1.left)){
                if(isSameTree(p1.right,q1.right)){
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}

