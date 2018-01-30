package com.weiyeli.JianZhiOffer;

/**
 * 数值的整数次方
 */
public class Power {
    public static double Power(double base, int exponent) throws IllegalArgumentException {
        // 如果指数为0返回1
        if (exponent == 0)
            return 1.0;
        else if (exponent > 0) {
            return PowerWithUnsignedExponent(base, exponent);
        }
        else {
            //判断base是不是0
            if (equal(base, 0.0)) {
                //应该抛出一个异常
                throw  new IllegalArgumentException();
            }else {
               int zexponent = Math.abs(exponent);
               return 1.0 / PowerWithUnsignedExponent(base, zexponent);
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

    //double不能直接判断
    private static boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1-num2 < 0.0000001))
            return true;
        else return false;
    }

    //通过递归优化我们的算法，而不是一味的做乘法
    private static double PowerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double result = PowerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        //如果是奇数，则还需要乘一次base
        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(Power(2,12));
    }
}
