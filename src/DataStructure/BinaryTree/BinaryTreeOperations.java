package DataStructure.BinaryTree;

public class BinaryTreeOperations {
    public static TreeNode buildTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;   n1.right = n3;
        n2.left = null; n2.right = null;    // 可以省略
        n3.left = n4;   n3.right = n5;
        n4.left = null; n4.right = null;
        n5.left = null; n5.right = null;

        return n1;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();

        System.out.print("前序：");
        preorder(root);
        System.out.println();

        System.out.print("中序：");
        inorder(root);
        System.out.println();

        System.out.print("后序：");
        postorder(root);
        System.out.println();

        int size = sizeof_1(root);
        System.out.println("结点个数: " + size);
        size = sizeof_1(root);
        System.out.println("结点个数: " + size);
        size = sizeof_1(root);
        System.out.println("结点个数: " + size);

        resultSize = 0;
        sizeof_2(root);
        System.out.println("结点个数: " + resultSize);


        resultSize = 0;
        sizeof_2(root);
        System.out.println("结点个数: " + resultSize);


        resultSize = 0;
        sizeof_2(root);
        System.out.println("结点个数: " + resultSize);


        int leafSize = leafSizeOf_1(root);
        System.out.println("叶子结点个数: " + leafSize);

        resultLeafSize = 0;
        leafSizeOf_2(root);
        System.out.println("叶子结点个数: " + resultLeafSize);

        resultLeafSize = 0;
        leafSizeOf_2(root);
        System.out.println("叶子结点个数: " + resultLeafSize);

        resultLeafSize = 0;
        leafSizeOf_2(root);
        System.out.println("叶子结点个数: " + resultLeafSize);

        int kSize = sizeofKLevel(root, 1);
        System.out.println("第1层: " + kSize);

        kSize = sizeofKLevel(root, 2);
        System.out.println("第2层: " + kSize);

        kSize = sizeofKLevel(root, 3);
        System.out.println("第3层: " + kSize);

        kSize = sizeofKLevel(root, 4);
        System.out.println("第4层: " + kSize);
        // 构建一棵空树，如何处理
        // 空树 <=> 一个结点都没有的树 <=> 没有根结点
//        root = null;
    }


    // 前序遍历（只进行打印）
    // 这个方法的含义：对 root 结点为根的树进行遍历
    public static void preorder(TreeNode root) {
        if (root == null) {
            // 根结点不存在 <=> 空树
            System.out.print("# ");
            return;
        }

        // 不是空树了
        // 前序遍历：根 + 左子树的前序遍历 + 右子树的前序遍历
        System.out.print(root.val + " ");   // 根

        // 对左子树进行前序遍历（把左子树的根 <=> 当前根的左孩子）
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            System.out.print("# ");
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) {
            System.out.print("# ");
            return;
        }
        // 从双亲进来，第一次经过该结点

        postorder(root.left);
        // 左子树回来，第二次经过该结点

        postorder(root.right);
        // 右子树回来，第三次经过该结点
        System.out.print(root.val + " ");
    }

    // 子问题的思想
    public static int sizeof_1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSize = sizeof_1(root.left);
        int rightSize = sizeof_1(root.right);

        int size = leftSize + rightSize + 1;
        return size;
    }

    // 线性思想
    private static int resultSize;
    private static void sizeof_2(TreeNode root) {
        if (root == null) {
            return;
        }

        resultSize = resultSize + 1;
        sizeof_2(root.left);
        sizeof_2(root.right);
    }

    // 求叶子结点个数
    // 子问题思想
    private static int leafSizeOf_1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 只有一个结点的树
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftSize = leafSizeOf_1(root.left);
        int rightSize = leafSizeOf_1(root.right);

        int leafSize = leftSize + rightSize;
        return leafSize;
    }

    // 线性的办法
    private static int resultLeafSize;
    private static void leafSizeOf_2(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null || root.right != null) {
            // 不是叶子
            leafSizeOf_2(root.left);
            leafSizeOf_2(root.right);
            return;
        }

        // 剩余情况 root.left == null && root.right == null
        resultLeafSize += 1;
    }

    private static int heightOf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOf(root.left);
        int rightHeight = heightOf(root.right);

        return Integer.max(leftHeight, rightHeight) + 1;
    }

    // 规定 root 所在的层是 1，k >= 1
    private static int sizeofKLevel(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

//        if (root.left == null && root.right == null) {
//            return k == 1 ? 1 : 0;
//        }

        if (k == 1) {
            return 1;
        }

        int leftSize = sizeofKLevel(root.left, k - 1);
        int rightSize = sizeofKLevel(root.right, k - 1);

        return leftSize + rightSize;
    }
}
