package com.stepyen.demo.animation.activity

import android.animation.Animator
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.animation.R
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.IntentLogUtil
import com.stepyen.demo.base.utils.L
import kotlinx.android.synthetic.main.activity_demo_test_animotion.*

/**
 * date：2020/12/12
 * author：stepyen
 * description：ce
 *
 */
@Route(path = PagePathHub.DemoTestAnimationActivity)
class DemoTestAnimationActivity : BasePageActivity() {

    override var TAG: String = "AnimotionTest"

    private var listTranslateAnimation: ObjectAnimator? = null      // 「列表」移动动画

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_test_animotion_2)


        testBtn.setOnClickListener {
            // 开始移动位置
            val currentTranslationX = testView.translationX

            val width = testView.width

            // 结束移动位置
            var endTranslationX =  currentTranslationX - width

            listTranslateAnimation = ObjectAnimator.ofFloat(testView, "translationX", currentTranslationX, endTranslationX)

            listTranslateAnimation?.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {

                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                }

            })

            listTranslateAnimation?.apply {
                duration = 1000
            }

            listTranslateAnimation?.start()

        }

    }






//    override fun initView() {
//
//        addView(R.layout.activity_demo_test_animotion)
//
//
//
//
////        test()
//
//    }

//
//    private fun test() {
//        addTag("测试动画")
//
//        addButton("缩放") {
//            val keyframe1 = Keyframe.ofFloat(0f, 1f)
//            val keyframe2 = Keyframe.ofFloat(0.2f, 1.5f)
//            val keyframe3 = Keyframe.ofFloat(0.45f, 1f)
//            val keyframe4 = Keyframe.ofFloat(0.8f, 1.5f)
//            val keyframe5 = Keyframe.ofFloat(1.0f, 1.0f)
//
//            val xHolder = PropertyValuesHolder.ofKeyframe(
//                "scaleX",
//                keyframe1, keyframe2, keyframe3, keyframe4, keyframe5
//            )
//            val yHolder = PropertyValuesHolder.ofKeyframe(
//                "scaleY",
//                keyframe1, keyframe2, keyframe3, keyframe4, keyframe5
//            )
//            ObjectAnimator.ofPropertyValuesHolder(iv, xHolder, yHolder)
//                .setDuration(1000)
//                .start()
//
//
//        }
//
//        addButton("摇晃") {
//
//            val rotationHolder = PropertyValuesHolder.ofKeyframe(
//                "rotation",
//                Keyframe.ofFloat(0f, 0f),
//                Keyframe.ofFloat(0.21f, 15f),
//                Keyframe.ofFloat(0.42f, -15f),
//                Keyframe.ofFloat(0.63f, 15f),
//                Keyframe.ofFloat(0.85f, -15f),
//                Keyframe.ofFloat(1.0f, 0f)
//            )
//            ObjectAnimator.ofPropertyValuesHolder(iv, rotationHolder)
//                .setDuration(1000)
//                .start()
//        }
//        addButton("果冻") {
//            val xHolder = PropertyValuesHolder.ofKeyframe(
//                "scaleX",
//                Keyframe.ofFloat(0f, 0.85f),
//                Keyframe.ofFloat(0.33f, 1.3f),
//                Keyframe.ofFloat(0.66f, 0.925f),
//                Keyframe.ofFloat(0.89f, 1.06f),
//                Keyframe.ofFloat(1.0f, 1.0f)
//            )
//            val yHolder = PropertyValuesHolder.ofKeyframe(
//                "scaleY",
//                Keyframe.ofFloat(0f, 1.3f),
//                Keyframe.ofFloat(0.33f, 0.85f),
//                Keyframe.ofFloat(0.66f, 1.15f),
//                Keyframe.ofFloat(0.89f, 0.97f),
//                Keyframe.ofFloat(1.0f, 1.0f)
//            )
//            ObjectAnimator.ofPropertyValuesHolder(iv, xHolder, yHolder)
//                .setDuration(450)
//                .start()
//
//        }
//
//
//        addButton("抖动") {
//            shake(iv, 1f, 1f, 2.5f, 1000)
//        }
//
//    }
//
//    private fun shake(
//        view: View,
//        scaleSmall: Float,
//        scaleLarge: Float,
//        shakeDegrees: Float,
//        duration: Long
//    ) {
//        //先变小后变大
//        val scaleXValuesHolder = PropertyValuesHolder.ofKeyframe(
//            View.SCALE_X,
//            Keyframe.ofFloat(0f, 1.0f),
//            Keyframe.ofFloat(0.25f, scaleSmall),
//            Keyframe.ofFloat(0.5f, scaleLarge),
//            Keyframe.ofFloat(0.75f, scaleLarge),
//            Keyframe.ofFloat(1.0f, 1.0f)
//        )
//        val scaleYValuesHolder = PropertyValuesHolder.ofKeyframe(
//            View.SCALE_Y,
//            Keyframe.ofFloat(0f, 1.0f),
//            Keyframe.ofFloat(0.25f, scaleSmall),
//            Keyframe.ofFloat(0.5f, scaleLarge),
//            Keyframe.ofFloat(0.75f, scaleLarge),
//            Keyframe.ofFloat(1.0f, 1.0f)
//        )
//
//        //先往左再往右
//        val rotateValuesHolder = PropertyValuesHolder.ofKeyframe(
//            View.ROTATION,
//            Keyframe.ofFloat(0f, 0f),
//            Keyframe.ofFloat(0.1f, -shakeDegrees),
//            Keyframe.ofFloat(0.2f, shakeDegrees),
//            Keyframe.ofFloat(0.3f, -shakeDegrees),
//            Keyframe.ofFloat(0.4f, shakeDegrees),
//            Keyframe.ofFloat(0.5f, -shakeDegrees),
//            Keyframe.ofFloat(0.6f, shakeDegrees),
//            Keyframe.ofFloat(0.7f, -shakeDegrees),
//            Keyframe.ofFloat(0.8f, shakeDegrees),
//            Keyframe.ofFloat(0.9f, -shakeDegrees),
//            Keyframe.ofFloat(1.0f, 0f)
//        )
//        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
//            view,
//            scaleXValuesHolder,
//            scaleYValuesHolder,
//            rotateValuesHolder
//        )
//        objectAnimator.duration = duration
//        objectAnimator.start()
//    }


}