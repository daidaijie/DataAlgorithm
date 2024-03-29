package com.weiyeli.JianZhiOffer.chapter4;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null)
            return null;

        ArrayList<Integer> ret = new ArrayList<>();

        // 起始行号
        int r1 = 0;
        // 结束行数
        int r2 = matrix.length - 1;
        // 起始列号
        int c1 = 0;
        // 结束列号
        int c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++)
                ret.add(matrix[r1][i]);
            for (int i = r1 + 1; i <= r2; i++)
                ret.add(matrix[i][c2]);
            // 如果只有一行，则不需要打印第二次了
            if (r1 != r2)
                for (int i = c2 - 1; i >= c1; i--)
                    ret.add(matrix[r2][i]);
            // 同理，如果只有一列，也不需要打印第二次
            if (c1 != c2)
                for (int i = r2-1; i > r1; i--)
                    ret.add(matrix[i][c1]);
            r1++;
            r2--;
            c1++;
            c2--;
        }

        return ret;
    }
}
