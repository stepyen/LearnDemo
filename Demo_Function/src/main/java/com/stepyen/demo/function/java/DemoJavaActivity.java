package com.stepyen.demo.function.java;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.stepyen.demo.abstractmethoderror.B;
import com.stepyen.demo.abstractmethoderror.use.A;
import com.stepyen.demo.base.PagePathHub;
import com.stepyen.demo.base.base.BasePageActivity;

/**
 * date：2021/1/30
 * author：stepyen
 * description：DemoJavaActivity
 */
@Route(path = PagePathHub.DemoJavaActivity)
public class DemoJavaActivity extends BasePageActivity {

    @Override
    public void initView() {
        addButton("AbstractMethodError", v->{
            new A().test();
        });
    }
}
