package com.weiyeli.JianZhiOffer.chapter4;

import com.weiyeli.JianZhiOffer.chapter3.TreeNode;

/**
 * 二叉搜索树与双向链表
 * 要求：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    // pre结点保存中序遍历的前一个结点
    private TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        inOrder(pRootOfTree);
        // 找到最小的子节点，就是双向链表的头结点
        while (pRootOfTree.left != null)
            pRootOfTree = pRootOfTree.left;

        return pRootOfTree;
    }

    /**
     * 中序遍历二叉搜索树
     * 将左子树的最大的结点指向根，根指向右子树的最小节点
     */
    private void inOrder(TreeNode node) {
        // 递归终止的条件
        if (node == null)
            return;
        // 递归遍历左子树
        inOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        // 递归遍历右子树
        inOrder(node.right);
    }
}
