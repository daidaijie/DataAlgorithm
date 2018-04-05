package com.weiyeli.DataStructure.tree.Tree_Traverse;

import java.util.Stack;

/**
 * 二叉树的遍历方式
 */
public class Traverse {

    /**
     * 先序非递归遍历
     *
     * @param root
     */
    public void rootFirstTraverse(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (root != null) {
            while (root != null) {
                // 首先访问根结点
                System.out.println(root.val);
                // 访问完压栈
                s.push(root);
                root = root.left;
            }
        }
    }

//    /**
//     * 中序非递归遍历
//     * @param root
//     */
//    public void rootMiddleTraverse(TreeNode root) {
//        Stack<TreeNode> s = new Stack<>();
//        while (root!=null)
//    }
}
