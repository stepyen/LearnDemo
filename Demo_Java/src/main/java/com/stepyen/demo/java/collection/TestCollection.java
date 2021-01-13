package com.stepyen.demo.java.collection;

import java.util.ArrayList;

/**
 * date：2021/1/12
 * author：stepyen
 * description：
 */
public class TestCollection {


    public static void main(String[] args) {
//        addNull();
//        nullException();
    }


    /**
     * 添加 null
     */
    private static void addNull() {
        ArrayList<String> list = new ArrayList<>();
        list.add(null);
        System.out.println("addNull succeed");
    }

    /**
     * 空指针异常
     */
    private static void nullException() {
        ArrayList<String> list = null;
        list.add("test");
        System.out.println("nullException succeed");
    }
}
