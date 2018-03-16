package com.weiyeli.Nowcoder.Aiqiyi.chapter1;

import java.util.Scanner;

/**
 * 循环数比较
 */
public class RepeatNumCompare {


    public static void main(String[] args) {
        int x1, k1, x2, k2;
        Scanner scanner = new Scanner(System.in);
        x1 = scanner.nextInt();
        k1 = scanner.nextInt();
        x2 = scanner.nextInt();
        k2 = scanner.nextInt();

        int length1 = 0;
        int length2 = 0;

        length1 = String.valueOf(x1).length() * k1;
        length2 = String.valueOf(x2).length() * k2;


        if (length1 < length2) {
            System.out.println("Less");
            return;
        }

        if (length1 > length2) {
            System.out.println("Greater");
            return;
        }

        if (length1 == length2) {
            StringBuffer str1 = new StringBuffer();
            StringBuffer str2 = new StringBuffer();
            char[] res1 = new char[500];
            char[] res2 = new char[500];

            for (int i = 0; i < k1; i++) {
                str1.append(x1);
            }

            for (int i = 0; i < k2; i++) {
                str2.append(x2);
            }

            res1 = str1.toString().toCharArray();
            res2 = str2.toString().toCharArray();

            for (int i = 0; i < length1; i++) {
                if (res1[i] < res2[i]) {
                    System.out.println("Less");
                    return;
                } else if (res1[i] > res2[i]) {
                    System.out.println("Greater");
                    return;
                }
            }

            System.out.println("Equal");
        }

    }
}
