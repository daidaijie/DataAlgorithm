package com.weiyeli.JianZhiOffer.chapter2;

import com.weiyeli.JianZhiOffer.chapter3.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 */
public class ReConstructBinaryTree {
    //缓存中序遍历数组的每个值对应的索引
    private Map<Integer, Integer> inOderNumsIndexs = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            inOderNumsIndexs.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL > preR || inL > inR)
            return null;

        TreeNode root = new TreeNode(pre[preL]);
        //首先找到根结点的序列号
        int inIndex = inOderNumsIndexs.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, in, inL, inL + leftTreeSize - 1);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, in, inL + leftTreeSize + 1, inR);
        return root;
    }
}
