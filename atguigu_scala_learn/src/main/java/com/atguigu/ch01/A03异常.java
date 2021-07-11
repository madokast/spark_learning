package com.atguigu.ch01;

public class A03异常 {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 1;
            System.out.println(b/a);
        }catch (Exception e){
            System.out.println("e = " + e);
        }finally {
            System.out.println("------------------");
        }
    }
}