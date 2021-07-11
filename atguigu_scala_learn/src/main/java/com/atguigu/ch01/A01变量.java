package com.atguigu.ch01;

public class A01变量 {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(int.class);
        System.out.println(Integer.valueOf(a).getClass());

        System.out.println(int.class);

        int b = 'a';
        System.out.println("b = " + b);
    }
}
