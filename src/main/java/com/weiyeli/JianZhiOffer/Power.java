package com.weiyeli.JianZhiOffer;

/**
 * 数值的整数次方
 */
public class Power {
    public static double Power(double base, int exponent) {
        if (exponent == 0)
            return 1.0;
        else if (exponent > 0) {
            return ZPower(base, exponent);
        }
        else {
            //判断base是不是0
            if (base == 0) {
                return 0;
            }else {
               int zexponent = Math.abs(exponent);
               return 1.0 / ZPower(base, zexponent);
            }
        }
    }

    public static double ZPower(double base, int exponent) {
        double sum = 1.0;
        for (int i = 0; i < exponent; i++) {
            sum *= base;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Power(0, 0));
    }
}
