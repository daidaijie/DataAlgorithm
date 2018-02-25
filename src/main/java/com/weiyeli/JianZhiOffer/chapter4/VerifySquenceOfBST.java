package com.weiyeli.JianZhiOffer.chapter4;

/**
 * 二叉搜索树的后序遍历序列
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        else return Verify(sequence, 0, sequence.length - 1);
    }

    private boolean Verify(int[] sequence, int start, int end) {
        if (end - start <= 1) return true;

        int root = sequence[end];
        int cutId = start;

        // 在二叉搜索树中左子树的结点小于根结点
        while (cutId < end) {
            if (sequence[cutId] > root) break;
            cutId++;
        }

        // 在二叉搜索树中右子树的结点大于根结点
        for (int i = cutId + 1; i < end; i++) {
            if (sequence[i] < root) return false;
        }

        // 递归判断左子树和右子树
        return Verify(sequence, start, cutId - 1) && Verify(sequence, cutId, end - 1);
    }
}
