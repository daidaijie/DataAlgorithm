package com.weiyeli.Nowcoder.String;

/**
 * 串的模式匹配
 */
public class StringPattern {
    // 自己写的脑残暴力方法
    public static int findAppearance(String A, int lena, String B, int lenb) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int k = -1;
        for (int i = 0; i < a.length; i++) {
            boolean flag = true;
            if (a[i] == b[0]) {
                int q = i+1;
                for (int j = 1; j < b.length; j++) {
                    if (a[q] != b[j]) {
                        flag = false;
                        break;
                    } else {
                        q++;
                    }
                }
                if (flag) {
                    k = i;
                    break;
                }
            }
        }

        return k;
    }

    public static void main(String[] args) {
        String a = "acbc";
        String b = "bc";
        System.out.println(findAppearance(a,4,b,2));
    }
}
