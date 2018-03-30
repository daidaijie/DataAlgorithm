package com.weiyeli.Nowcoder.Meituan;

import java.util.*;
public class ChunZhao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        char[] b = a.toCharArray();
        Arrays.sort(b);

        if (b[0]!='0' & b[0] > '1') {
            System.out.print(1);
            return;
        }

        if (b[0]=='0' & b[1] > '1') {
            System.out.print(1);
            return;
        }


//        for (int i = 0; i < b.length; i++) {
//            System.out.println(b[i]);
//        }
    }
}
