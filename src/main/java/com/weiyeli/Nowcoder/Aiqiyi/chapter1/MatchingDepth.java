package com.weiyeli.Nowcoder.Aiqiyi.chapter1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 括号匹配深度
 */
public class MatchingDepth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input == null || input.length() == 0)
            System.out.println(0);

        Stack<Integer> stack = new Stack<>();
        char[] a = input.toCharArray();

        
    }
}
