package com.stepyen.demo.animation.activity

import android.view.animation.*
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.animation.R
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import kotlinx.android.synthetic.main.demo_activity_tween_animotion.*

/**
 * date：2020/12/31
 * author：stepyen
 * description：补间动画
补间动画: 指定开始和结束的状态，中间的状态由系统自动完成。

具体四种动画：
Alpha Animation：透明度动画
Scale Animation：缩放动画
Translate Animation：平移动画
Rotate Animation：旋转动画




 */
@Route(path = PagePathHub.DemoTweenAnimotionActivity)
class DemoTweenAnimotionActivity : BasePageActivity() {

    private var translateAnimation: TranslateAnimation? = null


    override fun initView() {

        addView(R.layout.demo_activity_tween_animotion)

        /**
         * 缩放大小从0变成1，相对于自身的中心位置，时间500毫秒
         */
        btn_Scale.setOnClickListener {
            val animation = ScaleAnimation(
                0f, 1f, 0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
            )
            animation.duration = 500
            iv.startAnimation(animation)
        }

        /**
         * 位移
         */
        btn_Translate.setOnClickListener {
            translateAnimation = TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 1f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 1f
            )
            translateAnimation?.duration = 3000
            iv.startAnimation(translateAnimation)
        }

        /**
         * 位移   取消
         */
        btn_cancle_translate.setOnClickListener {
            translateAnimation?.cancel();
        }

        /**
         * 位移   重置
         */
        btn_reset_translate.setOnClickListener {
            translateAnimation?.reset();
        }

        /**
         * 旋转
         */
        btn_Rotate.setOnClickListener {
            val animation = RotateAnimation(
                0f, 720f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
            )
            animation.duration = 500
            iv.startAnimation(animation)
        }

        /**
         * 透明度
         */
        btn_Alpha.setOnClickListener {
            val animation = AlphaAnimation(0f, 1f)
            animation.duration = 2000
            iv.startAnimation(animation)
        }

        /**
         * 透明度  xml形式
         */
        btn_Scale_xml.setOnClickListener {
            val animation =
                AnimationUtils.loadAnimation(this, R.anim.anim_scale)
            iv.startAnimation(animation)
        }

        /**
         * 透明度和位移 xml形式
         */
        btn_Scale_and_translate.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(
                this,
                R.anim.anim_set_scale_and_translate
            )
            iv.startAnimation(animation)
        }


    }
}
