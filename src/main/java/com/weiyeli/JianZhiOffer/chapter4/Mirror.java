package com.weiyeli.JianZhiOffer.chapter4;

import com.weiyeli.JianZhiOffer.chapter3.TreeNode;

/**
 * 二叉树的镜像
 */
public class Mirror {

    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        // 交换左右结点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null)
            Mirror(root.left);

        if (root.right != null)
            Mirror(root.right);
    }
}
