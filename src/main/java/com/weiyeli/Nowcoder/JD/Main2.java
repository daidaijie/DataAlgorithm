package com.weiyeli.Nowcoder.JD;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            boolean flag = false;
            int n = scanner.nextInt();
            for (int i = 1; i < Math.sqrt(n); i++) {
                for (int j = (int) Math.sqrt(n); j < n; j++) {
                    if (i * j == n) {
                        if (isOddNum(i) && !isOddNum(j)) {
                            System.out.println(i + " " + j);
                            flag = true;
                            break;
                        }else if(isOddNum(j) && !isOddNum(i)){
                            System.out.println(j + " " + i);
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if (!flag)
                System.out.println("No");
        }
    }

    private static boolean isOddNum(int n) {
        return (n & 1) == 1;
    }
}
