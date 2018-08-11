package com.weiyeli.QiuZhao.PDD;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(6);
        list2.add(7);
        list2.add(8);

        System.out.println(list1.retainAll(list2));
        for (Integer i : list1) {
            System.out.println(i);
        }

        for (Integer i : list2) {
            System.out.println(i);
        }
    }
}
