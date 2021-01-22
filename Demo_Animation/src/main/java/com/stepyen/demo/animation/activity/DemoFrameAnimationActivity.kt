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
    private var isXml = true
    private var animationDrawable: AnimationDrawable? = null

    override fun initView() {
        addView(R.layout.activity_demo_frame_animotion)

        if (isXml) {
            animationDrawable = iv_animation_scale.drawable as AnimationDrawable?
        } else {
            animationDrawable = AnimationDrawable()
            animationDrawable?.isOneShot = false
            for (i in 0..76) {
                val drawableId = resources.getIdentifier(
                    "ic_frame_anim_" + i + 1,
                    "drawable",
                    packageName
                )
                val drawable =
                    resources.getDrawable(drawableId)
                animationDrawable?.addFrame(drawable, 100)
            }
        }

        tv_status.text = "当前为Xml实现"

        btn_switch.setOnClickListener {
            isXml = !isXml
            if (isXml) {
                tv_status.text = "当前为Xml实现"
            } else {
                tv_status.text = "当前为Java实现"
            }
        }

        btn_start.setOnClickListener {

            animationDrawable?.run() {
                stop()
                start()
            }

        }

        btn_stop.setOnClickListener {
            animationDrawable?.run() {
                stop()
            }
        }

    }
}