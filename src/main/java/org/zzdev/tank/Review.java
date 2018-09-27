package org.zzdev.tank;

public class Review {
    // 分为栈内存和堆内存，每个方法都有一个栈帧
//    public static void main(String[] args){
//        int i;
//        int j;
//        // 这个相当于在 main 方法的栈帧中，新建了局部对象r。在堆内存中新建了这个对象(this, super, i=0, j=0)
//        Review r = new Review();
//    }
    public static void main(String[] args) {
        Person p = new Person("laozhang");
        p.v = new Car();

        p.go("东北");
    }

}

class Person {
    String name;
    Vehicle v;
    public Person(String name) {
        this.name = name;
    }

    public void go(String where) {
        System.out.println(this.name + "驾驶着");
        // 每个对象都有一个虚？函数表（具体调用哪个run 需要运行的时候确定）因为在运行的时候才会 新建 car。这个就是动态绑定（绑定就是看到方法的名字，就去找car.class 的实现）
        // 继承  重写  父类的引用指向子类的引用
        v.run();
        System.out.println("去" + where);
    }
}

abstract class Vehicle {
    public abstract void run();
}

class Car extends Vehicle {

    @Override
    public void run() {
        System.out.println("car run");
    }
}

class broom extends Vehicle {

    @Override
    public void run() {
        System.out.println("Broom fly");
    }
}