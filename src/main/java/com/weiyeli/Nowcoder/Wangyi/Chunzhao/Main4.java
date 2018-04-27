package com.weiyeli.Nowcoder.Wangyi.Chunzhao;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 牛牛找工作
 * 原题链接：https://www.nowcoder.com/test/question/46e837a4ea9144f5ad2021658cb54c4d?pid=9763997&tid=15274603
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr, (e1, e2) -> (int) (e1[0] - e2[0]));

        for (int i = 1; i < arr.length; i++) {
            arr[i][1] = Math.max(arr[i - 1][1], arr[i][1]);
        }

        TreeMap map = new TreeMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i][0], arr[i][1]);
        }

        for (int i = 0; i < m; i++) {
            int ability = scanner.nextInt();
            Integer index = (Integer) map.floorKey(ability);
            if (index != null) {
                System.out.println(map.get(index));
            } else {
                System.out.println(0);
            }
        }
    }
}

