package com.weiyeli.QiuZhao.PDD;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<List<Integer>> a = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int j = 0;
            List<Integer> list = new LinkedList<>();
            if (i == 0)
                scanner.nextLine();
            String temp = scanner.nextLine();
            char[] temp1 = temp.toCharArray();
            for (int l = 0; l < temp1.length; l++) {
                if (temp1[l] >= '0' && temp1[l] <= '9')
                    list.add(temp1[l] - '0');
            }
            a.add(list);
        }

        int max  = 0;
        int res = -1;
        for (int i = 1; i < n; i++) {
            List<Integer> temp = new LinkedList<>();
            temp.addAll(a.get(0));
            temp.retainAll(a.get(i));
            int b = temp.size();
            if (b > max) {
                max = b;
                res = i;
            }
        }

        if (max == 0) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }
}
