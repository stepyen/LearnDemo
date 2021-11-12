package com.stepyen.demo.app

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import kotlinx.android.synthetic.main.demo_activity_test_android.*

/**
 * date：2021/11/12
 * author：stepyen
 * description：专用测试Android，测试完就删除，不提交代码
 *
 */
@Route(path = PagePathHub.DemoTestAndroidActivity)
class DemoTestAndroidActivity : AppCompatActivity(){

    var TAG: String = "DemoTestAndroidActivity_TAG"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_activity_test_android)

    }


}
