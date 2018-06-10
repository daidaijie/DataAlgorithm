package com.weiyeli.JianZhiOffer.chapter6;

/**
 * 题目：判断一棵树是不是平衡二叉树
 */
public class IsBalanced {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        postOrderTraverse(root);
        return isBalanced;
    }

    /**
     * 后序遍历
     * @param root
     * @return 当前结点的高度
     */
    private int postOrderTraverse(TreeNode root) {
        if (root == null)
            return 0;

        int left = postOrderTraverse(root.left);
        int right = postOrderTraverse(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;

        return 1 + Math.max(left, right);
    }
}
