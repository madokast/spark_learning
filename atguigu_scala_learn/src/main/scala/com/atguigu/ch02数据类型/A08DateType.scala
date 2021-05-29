package com.atguigu.ch02数据类型

object A08DateType {
  def main(args: Array[String]): Unit = {
    val a:AnyVal = 1
    println(a)
    println(a.isInstanceOf[Int])
    println(a.isInstanceOf[Integer])
    println(a.getClass) // Integer


    val b:Int = 1
    println(b)
    println(b.isInstanceOf[Int])
//    println(b.isInstanceOf[Integer])
    println(b.getClass) // int

    val c:AnyRef = java.lang.Integer.valueOf(100)
    println(c)
    println(c.isInstanceOf[Int])
    println(c.isInstanceOf[Integer])
    println(c.getClass) // Integer
  }
}

// //
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.atguigu.ch02数据类型;
//
//import scala.Predef.;
//import scala.runtime.BoxesRunTime;
//
//public final class A08DateType$ {
//    public static final A08DateType$ MODULE$ = new A08DateType$();
//
//    public void main(final String[] args) {
//        Object a = BoxesRunTime.boxToInteger(1);
//        .MODULE$.println(a);
//        .MODULE$.println(BoxesRunTime.boxToBoolean(a instanceof Integer));
//        .MODULE$.println(BoxesRunTime.boxToBoolean(a instanceof Integer));
//        .MODULE$.println(a.getClass());
//        int b = 1;
//        .MODULE$.println(BoxesRunTime.boxToInteger(b));
//        .MODULE$.println(BoxesRunTime.boxToBoolean(BoxesRunTime.boxToInteger(b) instanceof Integer));
//        .MODULE$.println(scala.runtime.ScalaRunTime..MODULE$.anyValClass(BoxesRunTime.boxToInteger(b), scala.reflect.ClassTag..MODULE$.Int()));
//    }
//
//    private A08DateType$() {
//    }
//}