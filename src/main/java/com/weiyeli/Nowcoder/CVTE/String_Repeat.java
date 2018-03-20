package com.weiyeli.Nowcoder.CVTE;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个注册码，返回其所有的重复字符个数，若没有重复则返回0
 * 注册码忽略大小写
 */
public class String_Repeat {
    public static int RepeatCount(String input) {
        Map<String, Integer> map = new HashMap<>();
        String a = input.toLowerCase();
        char b[] = a.toCharArray();
        int res = 0;
        for (int i = 0; i < b.length; i++) {
            if (!map.containsKey(String.valueOf(b[i]))) {
                map.put(String.valueOf(b[i]), 0);
            }else {
                if (map.get(String.valueOf(b[i])) == 0) {
                    res++;
                    map.replace(String.valueOf(b[i]), 1);
                    continue;
                } else {
                    continue;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(RepeatCount("aabbccddbj "));
    }
}
