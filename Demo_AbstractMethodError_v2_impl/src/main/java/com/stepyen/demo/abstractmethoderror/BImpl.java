package com.stepyen.demo.abstractmethoderror;

import android.util.Log;


/**
 * date：2021/1/30
 * author：stepyen
 * description：
 */
public class BImpl extends B {
    @Override
    public void change(int arg1,String arg2) {
        Log.d(TAG,"BImpl v2");
    }
}
