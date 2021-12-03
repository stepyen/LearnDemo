package com.stepyen.demo.app

import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
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

    val tv:TextView by lazy {
        TextView(this)?.apply {
            text = "哈哈哈哈"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_activity_test_android)

        addBtn.setOnClickListener {
            testLl.addView(tv)
        }

        removeAndAddBtn.setOnClickListener {
            if (tv.parent != null) {
                testLl.removeView(tv)
            }

            testLl.addView(tv)
        }
    }


}
