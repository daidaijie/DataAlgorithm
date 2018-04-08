package com.weiyeli.HDU;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        while (true) {
            n = scanner.nextInt();
            if (n == 0)
                break;
            else {
                while (n-- > 0) {
                    double x1 = scanner.nextDouble();

                    double[][] db = new double[3][2];
                    db[0][0] = x1;
                    db[0][1] = scanner.nextDouble();
                    db[1][0] = scanner.nextDouble();
                    db[1][1] = scanner.nextDouble();
                    db[2][0] = scanner.nextDouble();
                    db[2][1] = scanner.nextDouble();

                    double resX = (db[0][0] + db[1][0] + db[2][0]) / 3;
                    double resY = (db[0][1] + db[1][1] + db[2][1]) / 3;
                    System.out.printf("%.1f", resX);
                    System.out.printf(" %.1f\n", resY);
                }
            }
        }
    }
}
