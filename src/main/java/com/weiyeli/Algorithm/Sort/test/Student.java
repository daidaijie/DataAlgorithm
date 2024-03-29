package com.weiyeli.Algorithm.Sort.test;

public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //定义Student的compreTo函数
    //如果分数相等，则按照名字的字母序排序
    //如果分数不等，则分数高的靠前

    public int compareTo(Student o) {

        if (this.score == o.score)
            return this.name.compareTo(o.name);

        if (this.score < o.score)
            return -1;
        else if(this.score > o.score)
            return 1;
        return 0;
    }

    //定义Student实例的打印输出方式
    @Override
    public String toString() {
        return "Student: " + this.name + " " + Integer.toString(this.score);
    }
}
