package com.weiyeli.Nowcoder.dp;

/**
 * 最长递增子序列
 */
public class AscentSequence {
    /**
     * 状态转移方程：dp[i] = max{dp[j]+1(0<=j<i,arr[j]<arr[i])}
     * 时间复杂度为O(n^2)
     *
     * @param A
     * @param n
     * @return
     */
    public static int findLongest(int[] A, int n) {
        // dp[i]表示必须以A[i]结尾的子序列的最大长度
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            if (max != Integer.MIN_VALUE)
                dp[i] = max + 1;
            else dp[i] = 1;
        }

        // 找到最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max)
                max = dp[i];
        }

        return max;
    }

    /**
     * O(NlogN)的算法
     *
     * @param a
     * @param n
     * @return
     */
    public static int findLongest2(int[] a, int n) {
        //我们的b数组，是存储对应长度LIS的最小末尾(说白了就是对状态的一种优化，只保留了尾部最小的状态)
        //因为尾部最小的子序列找到更长的LIS的可能性更大
        //https://blog.csdn.net/u012198382/article/details/25001663
        int[] b = new int[n];
        b[0] = a[0];
        int end = 0;
        for (int i = 1; i < n; i++) {
            // 如果当前数比B中最后一个数还大，直接添加
            if (a[i] > b[end]) {
                b[++end] = a[i];
                continue;
            }
            // 否则，需要先找到替换位置
            int pos = findInsertPos(b,a[i],0,end);
            b[pos] = a[i];
        }

        // end是从0开始的，所以最后结果+1
        return end + 1;
    }

    /**
     * 二分查找第一个大于等于n的位置
     */
    private static int findInsertPos(int[] b, int n, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (n>b[mid]) {
                start = mid + 1;
            }else if (n < b[mid]) {
                end = mid;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3, 1, 5, 6};
        System.out.println(findLongest(a, 7));
        System.out.println(findLongest2(a,7));
    }
}
