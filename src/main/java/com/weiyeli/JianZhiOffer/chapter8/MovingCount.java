package com.weiyeli.JianZhiOffer.chapter8;

/**
 * 机器人的运动范围
 */
public class MovingCount {
    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }

    private void dfs(boolean[][] marked, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
            return;
        //先访问当前结点
        marked[r][c] = true;
        if (this.digitSum[r][c] > this.threshold)
            return;
        cnt++;
        //四个方向进行深搜
        for (int[] n : next)
            dfs(marked, r + n[0], c + n[1]);
    }


    private void initDigitSum() {
        //算出所有的每一个数字的数位和
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while (n > 0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }

        digitSum = new int[rows][cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }
}
