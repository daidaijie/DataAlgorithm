package com.weiyeli.Algorithm.Sort.Insert;

import java.util.Scanner;

/**
 * 插入排序
 */
public class InsertSort {
    static int a[] = new int[11];

    /**
     * 直接插入排序
     * @param a
     */
    public static void insertSort(int a[]) {
        for (int i = 2; i <= a.length; i++) {
            int j = i - 1;
            a[0] = a[i];
            while (a[0] < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = a[0];
        }

        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /*
    折半插入排序
     */
    public static void BinInsSort(int v[]) {
        int temp;
        int left, right;
        for (int i = 1; i < v.length; i++) {
            left = 0;
            right = i - 1;
            temp = v[i];
            while (left <= right) {
                int mid = (left + right) / 2;
                if (temp < v[mid])
                    right = mid - 1;
                else left = mid + 1;
            }
            for (int k = i-1; k >=left ; k--) {
                v[k+1] = v[k];
            }
            v[left] = temp;
        }

        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /*
    希尔排序
     */
    public static void shellSort(int a[]) {
        double d1 = a.length;
        int temp = 0;
        while (true) {
            d1 = Math.ceil(d1 / 2);
            int d = (int) d1;

            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i += d) {
                    int j = i - d;
                    temp = a[i];
                    for (; j >= 0 && temp < a[j]; j -= d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }

            if (d == 1) {
                break;
            }
        }

        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++)
            a[i] = scanner.nextInt();

        //insertSort(a);
        BinInsSort(a);
    }
}
