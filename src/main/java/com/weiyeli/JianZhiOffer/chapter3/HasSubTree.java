package com.weiyeli.JianZhiOffer.chapter3;

public class HasSubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            // 如果两个结点的值一样，则看树1是否包含树2
            if (root1.val == root2.val)
                result = DoesTree1HaveTree2(root1, root2);
            // 如果当前结点不满足，则递归搜索左子树和右子树
            if (result == false)
                result = HasSubtree(root1.left, root2);
            if (result == false)
                result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        // 如果root2为空，则说明前面相等的两个结点有包含关系
        if (root2 == null)
            return true;

        // 如果root1为空，则肯定不包含
        if (root1 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }
}
