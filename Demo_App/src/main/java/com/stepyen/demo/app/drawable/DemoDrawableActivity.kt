package com.stepyen.demo.app.drawable

import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.TransitionDrawable
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.app.R
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import kotlinx.android.synthetic.main.activity_drawable.*

/**
 * date：2021/1/15
 * author：stepyen
 * description：
 *
 */

@Route(path = PagePathHub.DemoDrawableActivity)
class DemoDrawableActivity : BasePageActivity(){

    override fun initView() {
        addView(R.layout.activity_drawable)

        btn_transition_start.setOnClickListener {
            (iv_transition.drawable as TransitionDrawable).startTransition(500)
        }

        btn_transition_reverse.setOnClickListener {
            (iv_transition.drawable as TransitionDrawable).reverseTransition(500)
        }

        btn_transition_reset.setOnClickListener {
            (iv_transition.drawable as TransitionDrawable).resetTransition()
        }

        btn_clip.setOnClickListener {
            (iv_clip.background as ClipDrawable).level+=1000
        }



    }


}
