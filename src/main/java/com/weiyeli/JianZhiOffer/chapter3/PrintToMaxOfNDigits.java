package com.weiyeli.JianZhiOffer.chapter3;

public class PrintToMaxOfNDigits {

    public static void PrintToMaxOfNDigits(int n) {
        if (n <= 0)
            return;

        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }

        while (!Increment(number)) {
            System.out.println(number);
        }
    }

    private static boolean Increment(char[] number) {
        boolean isOverflow = false;
        // 进位符
        int nTakeOver = 0;
        int length = number.length;

        for (int i = length - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            //从最后一个开始加1
            if (i == length - 1)
                nSum++;

            if (nSum == 10) {
                if (i == 0)
                    isOverflow = true;
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) (nSum + 48);
                }
            } else {
                number[i] = (char) (nSum + 48);
                break;
            }
        }

        return isOverflow;
    }

    /**
     * 把问题转换成数字排列的解法，递归让代码更简洁
     *
     * @param n
     */
    public static void PrintToMaxOfNDigits2(int n) {
        if (n <= 0)
            return;

        char[] number = new char[n];

        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + 48);
            //index代表的意思是现在已经处理了第几位，从0开始
            PrintToMaxOfNDigitsRecursively(number, n ,0);
        }

    }

    private static void PrintToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length -1){
            System.out.println(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index+1] = (char) (i + 48);
            PrintToMaxOfNDigitsRecursively(number, length, index+1);
        }
    }

    public static void main(String[] args) {
        PrintToMaxOfNDigits2(3);
    }
}
