package com.weiyeli.Nowcoder.String;

/**
 * 字符串的旋转
 */
public class StringRotation {
    // 自己写的脑残方法
    public static String rotateString(String A, int n, int p) {
        String a = A.substring(0, p + 1);
        StringBuilder sb = new StringBuilder();
        sb.append(A.substring(p + 1, A.length()));
        sb.append(a);
        return sb.toString();
    }

    // 牛客网大佬的神奇方法
    public static String rotateString2(String A, int n, int p) {
        return (A+A).substring(p+1,p+n+1);
    }

    public static void main(String[] args) {
        String a = "ABCDEFGH";
        System.out.println(rotateString2(a, 8, 4));
    }
}
