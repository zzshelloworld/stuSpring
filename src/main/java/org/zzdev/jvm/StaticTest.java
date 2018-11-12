package org.zzdev.jvm;
// https://mp.weixin.qq.com/s/VBbNm2N20DotmGYlSEBS8g
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    final static int b = 112;

    // 对static 代码块不清楚
    // 加载 连接(验证，准备，解析) 初始化 只有在准备阶段和初始化阶段进行 类变量的初始化和赋值
    // 3 a=110, b=0 4 1 2
}