package com.stepyen.demo.java;

import java.text.DecimalFormat;

/**
 * date：2021/2/3
 * author：stepyen
 * description：
 */
class Test {

    /**
     *
     *
     *  int time = 1800;
     *         int hour = time / 1000 / 3600;
     *         int minute = time / 1000 / 60 % 60;
     *         float second = time / 1000f % 60;
     *
     *         int secondInt = (int) second;
     *
     *         System.out.println("hour: " + hour);
     *         System.out.println("minute: " + minute);
     *         System.out.println("second: " + secondInt);
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        DecimalFormat df=new DecimalFormat("0000");
        String str2=df.format(1);
        System.out.println(str2);

    }
}
