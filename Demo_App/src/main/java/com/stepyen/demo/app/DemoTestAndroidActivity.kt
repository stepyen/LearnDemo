package com.stepyen.demo.app

import android.app.Activity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.utils.L
import java.lang.StringBuilder

/**
 * date：2021/11/12
 * author：stepyen
 * description：专用测试Android，测试完就删除，不提交代码
 *
 */
@Route(path = PagePathHub.DemoTestAndroidActivity)
class DemoTestAndroidActivity : Activity(){

    var TAG: String = "DemoTestAndroidActivity_TAG"

    val tv:TextView by lazy {
        TextView(this)?.apply {
            text = "哈哈哈哈"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.demo_activity_test_android)

//        addBtn.setOnClickListener {
//            testLl.addView(tv)
//        }
//
//        removeAndAddBtn.setOnClickListener {
//            if (tv.parent != null) {
//                testLl.removeView(tv)
//            }
//
//            testLl.addView(tv)
//        }

        L.d("haha",StringUtis.urlAppendPara("http://example.com","",""))
        L.d("haha",StringUtis.urlAppendPara("http://example.com#fragment","name","John"))
        L.d("haha",StringUtis.urlAppendPara("http://example.com?email=john.doe@email.com","name","John"))





    }




    override fun onStart() {
        super.onStart()
        Log.d("haha","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("haha","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("haha","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("haha","onStop")
    }


}
