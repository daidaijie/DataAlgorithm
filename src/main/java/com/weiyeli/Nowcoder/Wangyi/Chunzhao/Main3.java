package com.weiyeli.Nowcoder.Wangyi.Chunzhao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 牛牛找工作
 * 题目大意：求所给能力值范围以内的最大报酬
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] job = new int[n][2];

        for (int i = 0; i < n; i++) {
            //难度
            job[i][0] = scanner.nextInt();
            //报酬
            job[i][1] = scanner.nextInt();
        }

        //按照工作难度排序
        Arrays.sort(job, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //利用TreeMap存储我们的job
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        //第一项工作先加进去
        treeMap.put(job[0][0], job[0][1]);

        //将每个工作的报酬改为小于等于他的难度的报酬的最大值
        for (int i = 1; i < n; i++) {
            job[i][1] = Math.max(job[i - 1][1], job[i][1]);
            treeMap.put(job[i][0], job[i][1]);
        }


        for (int i = 0; i < m; i++) {
            Integer pos = treeMap.floorKey(scanner.nextInt());
            if (pos == null) {
                System.out.println(0);
            } else {
                System.out.println(treeMap.get(pos));
            }
        }
    }
}
