package com.stepyen.demo.java.exception;

/**
 * date：2020/12/17
 * author：stepyen
 * description：
 */
public class TestException{


    public static void main(String[] args) {
       // 测试 注册捕获异常
        new Test().testCatchException();

//        除0异常
        int i = 12 / 0;


    }





    public static class Test implements Thread.UncaughtExceptionHandler {

        /**
         * 测试捕获异常
         */
        public void testCatchException() {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }


        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

}
