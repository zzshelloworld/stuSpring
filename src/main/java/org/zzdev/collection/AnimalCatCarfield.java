package org.zzdev.collection;

import java.util.ArrayList;
import java.util.List;

public class AnimalCatCarfield {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Carfield> carfields = new ArrayList<>();

        animals.add(new Animal());
        cats.add(new Cat());
        carfields.add(new Carfield());
//      只能是cat本身或者cat的子类
//        List<? extends Cat> extendsanimal = animals;
        List<? super Cat> superanimal = animals;
        List<? extends Cat> extendcat = cats;
        List<? super Cat> supercat = cats;
        List<? extends Cat> extendcar = carfields;
//        只能是cat本身或cat的父类
//        List<? super Cat> supercar = carfields;

//        extendcat.add(new Animal());
//        extendcat.add(new Cat());
//        extendcat.add(new Carfield());

//        只能添加cat和cat的子类
//        supercat.add(new Animal());
        supercat.add(new Cat());
        supercat.add(new Carfield());

//        所用的super能够返回值，但是为object，因为泛型丢失
//

    }
}

class Animal {

}

class Cat extends Animal {

}

class Carfield extends Cat {

}
