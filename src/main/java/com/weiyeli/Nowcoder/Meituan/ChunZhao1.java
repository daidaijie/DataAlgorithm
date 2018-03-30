package com.weiyeli.Nowcoder.Meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChunZhao1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int n = b.length();
        int q = a.length() - b.length() + 1;
        int res = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < q; i++) {
//            list.add(a.substring(i, i + n));

//        for (int i = 0; i < list.size(); i++) {
            if (i+n > a.length())
                break;

            String s = a.substring(i, i + n);
            int sum = 0;
            char[] charsA = s.toCharArray();
            char[] charsB = b.toCharArray();
            for (int j = 0; j < charsA.length; j++) {
                if (charsA[j] != charsB[j])
                    sum++;
            }
            res += sum;
        }

        System.out.println(res);
    }
}
