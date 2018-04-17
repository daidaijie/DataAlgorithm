package com.weiyeli.Nowcoder.Tencent;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 腾讯面试算法题
 * 求根号2的任意第N位数
 */
public class Main4 {

    private static String getNOfSqrt2(int n) {
        String str = new BigDecimal(Math.pow(10, n - 1) + "").toPlainString();
        String ss = str.toString();
        String inte = str.split("\\.")[0];
        BigInteger w = new BigInteger(inte);
        BigInteger x = new BigInteger("1");
        BigInteger y = new BigInteger("0");
        while (x.compareTo(w) < 0 && y.compareTo(w) < 0) {
            x = x.add(y.multiply(new BigInteger("2")));
            y = x.add(y);
        }

        String s = w.subtract(y).multiply(x.subtract(y)).toString();
        BigInteger bigInteger = new BigInteger(s);
        bigInteger = bigInteger.mod(y);
        BigDecimal res = new BigDecimal(bigInteger);
        res = res.divide(new BigDecimal(y), 5, BigDecimal.ROUND_DOWN);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(getNOfSqrt2(8));
    }
}
