package com.weiyeli.QiuZhao.Dji;

public interface Test {
    static void fun() {
        System.out.println("Java 8 新特性！");
    }

    default void fun1() {
        System.out.println("Java 8 新特性 + 1");
    }
}
