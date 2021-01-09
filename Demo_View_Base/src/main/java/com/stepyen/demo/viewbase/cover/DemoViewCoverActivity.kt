package com.stepyen.demo.viewbase.cover

import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.viewbase.R
import kotlinx.android.synthetic.main.activity_demo_view_cover.*

/**
 * date：2020/12/18
 * author：stepyen
 * description：研究View遮盖问题
 *
 */
class DemoViewCoverActivity : BasePageActivity() {

    override var TAG: String = "DemoViewCover_TAG"

    override fun initView() {
        addView(R.layout.activity_demo_view_cover)


        view1Button1.setOnClickListener {
            L.d(TAG,"点击 view1Button1")
        }

        view2Button1.setOnClickListener {
            L.d(TAG,"点击 view2Button1")
        }

        view3Button1.setOnClickListener {
            L.d(TAG,"点击 view3Button1")
        }


    }



}


