package com.weiyeli.JianZhiOffer.chapter4;

import com.weiyeli.JianZhiOffer.chapter3.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 */
public class FindPath {

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        dfs(root, target, 0, new ArrayList<>());
        return ret;
    }

    private void dfs(TreeNode node, int target, int curSum, ArrayList<Integer> path) {
        if (node == null) return;
        curSum += node.val;
        path.add(node.val);
        if (curSum == target && node.left == null && node.right == null)
            ret.add(new ArrayList<>(path));
        else {
            dfs(node.left, target, curSum, path);
            dfs(node.right, target, curSum, path);
        }

        // 左右孩子都不行，就返回父亲结点，删除本结点
        path.remove(path.size()-1);
    }
}
