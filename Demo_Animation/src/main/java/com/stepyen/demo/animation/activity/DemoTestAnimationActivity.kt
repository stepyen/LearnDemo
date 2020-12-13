package com.stepyen.demo.animation.activity

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.widget.ImageView
import com.stepyen.demo.animation.R
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2020/12/12
 * author：stepyen
 * description：
 *
 */
class DemoTestAnimationActivity :BasePageActivity(){

    override var TAG: String = "AnimotionTest"
    private lateinit var iv: ImageView

    override fun initView() {
        val view = addView(R.layout.activity_demo_test_animotion)
        iv = view.findViewById(R.id.iv)
        addButton("缩放") {
            val keyframe1 = Keyframe.ofFloat(0f, 1f)
            val keyframe2 = Keyframe.ofFloat(0.2f, 1.5f)
            val keyframe3 = Keyframe.ofFloat(0.45f, 1f)
            val keyframe4 = Keyframe.ofFloat(0.8f, 1.5f)
            val keyframe5 = Keyframe.ofFloat(1.0f, 1.0f)

            val xHolder = PropertyValuesHolder.ofKeyframe("scaleX",
                keyframe1, keyframe2, keyframe3, keyframe4, keyframe5
            )
            val yHolder = PropertyValuesHolder.ofKeyframe("scaleY",
                keyframe1, keyframe2, keyframe3, keyframe4, keyframe5
            )
            ObjectAnimator.ofPropertyValuesHolder(iv, xHolder, yHolder)
                .setDuration(1000)
                .start()


        }

        addButton("摇晃") {

            val rotationHolder = PropertyValuesHolder.ofKeyframe("rotation",
                Keyframe.ofFloat(0f, 0f),
                Keyframe.ofFloat(0.21f, 15f),
                Keyframe.ofFloat(0.42f, -15f),
                Keyframe.ofFloat(0.63f, 15f),
                Keyframe.ofFloat(0.85f, -15f),
                Keyframe.ofFloat(1.0f, 0f)
            )
            ObjectAnimator.ofPropertyValuesHolder(iv, rotationHolder)
                .setDuration(1000)
                .start()
        }
        addButton("果冻") {
            val xHolder = PropertyValuesHolder.ofKeyframe("scaleX",
                Keyframe.ofFloat(0f, 0.85f),
                Keyframe.ofFloat(0.33f, 1.3f),
                Keyframe.ofFloat(0.66f, 0.925f),
                Keyframe.ofFloat(0.89f, 1.06f),
                Keyframe.ofFloat(1.0f, 1.0f)
            )
            val yHolder = PropertyValuesHolder.ofKeyframe("scaleY",
                Keyframe.ofFloat(0f, 1.3f),
                Keyframe.ofFloat(0.33f, 0.85f),
                Keyframe.ofFloat(0.66f, 1.15f),
                Keyframe.ofFloat(0.89f, 0.97f),
                Keyframe.ofFloat(1.0f, 1.0f))
            ObjectAnimator.ofPropertyValuesHolder(iv, xHolder, yHolder)
                .setDuration(450)
                .start()

        }
    }

}