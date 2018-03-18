package com.weiyeli.Nowcoder.Wangyi;

import java.util.Scanner;

/**
 * 优雅的点
 */
public class Grace_Point {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int r = (int) Math.sqrt(a);
        int res = 0;
        // 利用勾股定理,x^2+y^2=r^2
        for (int i = r; i > 0; i--) {
            // 把i=0到i=r的所有整数遍历一遍，如果得到的x是整数，则得到的点是优雅点
            int x = (int) Math.sqrt(a - i * i);
            if (x * x + i * i == a)
                res += 4;
        }
        System.out.println(res);
    }
}
