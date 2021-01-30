package com.stepyen.demo.java.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * date：2019/9/6
 * author：stepyen
 * description：Java 泛型学习
 */
public class JavaGenericity {
    public static class Animal{
        public void cry() {
            System.out.println("Animal#cry");
        }
    }

    public static class Dog extends Animal {
        public void cry() {
            System.out.println("Dog#cry");
        }
    }


    public static void main(String[] args) {


    }


    public static void test(Animal animal) {



    }



}
