package com.stepyen.demo.animation.activity

import android.graphics.drawable.AnimationDrawable
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.animation.R
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import kotlinx.android.synthetic.main.activity_demo_frame_animotion.*

/**
 * date：2020/12/12
 * author：stepyen
 * description：帧动画
 *
 */
@Route(path = PagePathHub.DemoFrameAnimationActivity)
class DemoFrameAnimationActivity : BasePageActivity() {

    private var animationDrawable: AnimationDrawable? = null

    override fun initView() {
        addView(R.layout.activity_demo_frame_animotion)

        xml_start_btn.setOnClickListener {
            animationDrawable = iv_animation_scale.drawable as AnimationDrawable?
            animationDrawable?.run() {
                stop()
                start()
            }
        }
        xml_stop_btn.setOnClickListener {
            animationDrawable?.stop()
        }



        // 不起作用，待查！！！！！！
        code_start_btn.setOnClickListener {

            animationDrawable = AnimationDrawable()
            animationDrawable?.isOneShot = false
            for (index in 1..77) {
                val drawableId = resources.getIdentifier(
                    "ic_frame_anim_$index",
                    "drawable",
                    packageName
                )
                val drawable =
                    resources.getDrawable(drawableId)
                animationDrawable?.addFrame(drawable, 100)
            }
            animationDrawable?.run() {
                stop()
                start()
            }
        }
        code_stop_btn.setOnClickListener {
            animationDrawable?.stop()
        }




    }
}