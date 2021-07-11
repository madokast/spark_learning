package com.atguigu.ch04函数

object A04FunParm {
  def main(args: Array[String]): Unit = {
    def f(a: Int = 1, b: Int = 2) = a + b

    println(f())
    println(f(b = 10))
  }
}

/*
反编译后是这样的

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atguigu.ch04函数;

import scala.Predef.;
import scala.runtime.BoxesRunTime;

public final class A04FunParm$ {
    public static final A04FunParm$ MODULE$ = new A04FunParm$();

    public void main(final String[] args) {
        .MODULE$.println(BoxesRunTime.boxToInteger(f$1(f$default$1$1(), f$default$2$1())));
         var10000 = .MODULE$;
        int x$1 = true;
        int x$2 = f$default$1$1();
        var10000.println(BoxesRunTime.boxToInteger(f$1(x$2, 10)));
    }

    private static final int f$1(final int a, final int b) {
        return a + b;
    }

    private static final int f$default$1$1() {
        return 1;
    }

    private static final int f$default$2$1() {
        return 2;
    }

    private A04FunParm$() {
    }
}

 */
