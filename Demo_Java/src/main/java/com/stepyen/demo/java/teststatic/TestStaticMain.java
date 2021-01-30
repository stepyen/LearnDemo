package com.stepyen.demo.java.teststatic;

/**
 * date：2021/1/26
 * author：stepyen
 * description：
 */
class TestStaticMain {


    public static void main(String[] args) {

        /**
         * 输出：StaticA test
         * 结论：静态方法不能重写
         */
        StaticB.jump();
    }

}
