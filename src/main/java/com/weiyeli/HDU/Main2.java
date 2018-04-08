package com.weiyeli.HDU;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if ((a+b)%86==0) {
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }
}
