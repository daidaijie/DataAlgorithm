package com.weiyeli.Leetcode.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. House Robber III
 * https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
 * rob1和rob2的解法时间复杂度相差很大,原因是rob1含有大量的重复计算
 * rob2和rob3的复杂度相差在于rob2并没有保存偷还是不偷这两种状态分别的最大值，只是返回了一个偷的最大值，我们在回溯的过程中需要再次计算不偷的情况，这里就是重复递归了
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class LeetCode337 {
    //这个题有点类似于213题，因为不能相邻，所以只能隔一层隔一层的去累加，这就分为两种情况
    //如果算上根节点，那就1,3,5...这样去找
    //如果不算根节点，就2,4,6...这样去找
    public int rob1(TreeNode root) {
        if (root == null) return 0;

        int val = 0;

        if (root.left != null) {
            val += rob1(root.left.left) + rob1(root.left.right);
        }

        if (root.right != null) {
            val += rob1(root.right.left) + rob1(root.right.right);
        }

        return Math.max(val + root.val, rob1(root.left) + rob1(root.right));
    }

    /**
     * 记忆化搜索，方法1中含有大量的重叠子问题
     * 空间复杂度为O(n)，不考虑栈的消耗
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        return robSub(root, new HashMap<TreeNode, Integer>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null)
            return 0;

        if (map.containsKey(root))
            return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));

        map.put(root, val);

        return val;
    }

    /**
     * 如果你追溯到一开始，你会发现答案就在于我们如何定义rob（root）。正如我所提到的，对于每个树根来说，都有两种情况：它被抢夺或不被抢夺。
     * rob（root）并没有区分这两种情况，所以“随着递归越来越深，信息就会丢失”，这会导致重复的子问题。
     * 如果我们能够维护每个树根的两个场景的信息，让我们看看它是如何发挥出来的。将rob（root）重新定义为一个新函数，
     * 该函数将返回一个包含两个元素的数组
     * 其中第一个元素表示如果root没有被盗取可抢劫的最大金额
     * 而第二个元素表示抢劫的最大金额如果是抢劫。
     * @param root
     * @return
     */
    public int rob3(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        //对于rob（root）的第一个元素，我们只需要总结rob（root）的较大元素。左）和rob（root.right），因为根没有被抢劫，我们可以自由地抢夺它的左右子树。
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //然而，对于rob（root）的第二个元素，我们只需要分别将rob（root.left）和rob（root.right）的第一个元素加上从root本身抢劫的值，因为在这种情况下它保证我们不能抢劫root.left和root.right的节点。
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
