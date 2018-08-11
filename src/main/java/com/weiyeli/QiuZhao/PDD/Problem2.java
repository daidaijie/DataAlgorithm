package com.weiyeli.QiuZhao.PDD;

import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] a = input.toCharArray();
        int length = a.length;

        int index = 0;
        for (int i = 0; i < length; i++) {
            if (a[i] == '0')
                index = i;
        }
    }
}
