package com.stepyen.demo.abstractmethoderror.use;

import com.stepyen.demo.abstractmethoderror.B;
import com.stepyen.demo.abstractmethoderror.BImpl;

/**
 * date：2021/1/30
 * author：stepyen
 * description：
 */
public class A {
    public B b = new BImpl();

    public void test(){
        b.change(123, "1234");
    }
}
