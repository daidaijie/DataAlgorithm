package com.weiyeli.JianZhiOffer.chapter4;

import com.weiyeli.JianZhiOffer.chapter3.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * 即按层打印二叉树
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        queue.add(root);
        TreeNode current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            list.add(current.val);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return list;
    }
}
