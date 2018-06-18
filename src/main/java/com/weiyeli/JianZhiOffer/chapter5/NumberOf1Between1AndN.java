package com.weiyeli.JianZhiOffer.chapter5;

/**
 * 面试题32：从1到n整数中1出现的次数
 * 大神解答：https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
 */
public class NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN_Solution(int n) {

        //1的个数
        int count = 0;

        //当前位
        int i = 1;

        int current, after = 0, before = 0;

        while ((n / i) != 0) {

            current = (n / i) % 10;     //当前数字
            before = n / (i * 10);      //高位数字
            after = n - (n / i) * i;    //低位数字

            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0)
                count += before * i;
            //如果为1，出现1的次数由高位和低位决定,高位*当前位+低位+1
            else if(current == 1)
                count += before * i + after + 1;
            //如果大于1,出现1的次数由高位决定 -- (高位数字+1) * 当前位数
            else {
                count += (before + 1) * i;
            }

            //前移一位
            i = i * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(12345));
    }
}
