package com.stepyen.demo.animation.activity

import android.animation.*
import com.stepyen.demo.animation.R
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import kotlinx.android.synthetic.main.demo_activity_property_animotion.*

/**
 * date：2020/12/31
 * author：stepyen
 * description：
 *
 */
class DemoPropertyAnimotionActivity : BasePageActivity() {

    override var TAG: String = "DemoPropertyAnimotion_TAG"


    override fun initView() {
        addView(R.layout.demo_activity_property_animotion)

        addTag("属性动画")

        addButton("alpha-ValueAnimator方式实现") { v ->
            val animator = ValueAnimator.ofFloat(0f, 1f)
            animator.duration = 1000
            animator.addUpdateListener { animation ->
                val value = animation.animatedValue as Float
                iv.alpha = value
            }
            animator.start()
        }

        addButton("alpha-ObjectAnimator方式实现") { v ->
            val objectAnimator = ObjectAnimator.ofFloat(iv, "alpha", 0f, 1f)
            objectAnimator.duration = 1000
            objectAnimator.start()
        }

        addButton("ObjectAnimator 实现Scale") { v ->
            val animator = ObjectAnimator.ofFloat(iv, "scaleX", 1f, 0.5f, 1f)
            animator.duration = 3000
            animator.start()
        }

        addButton("PropertyValuesHolder 实现Scale 多个动画效果") { v ->
            val xHolder =
                PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f, 1.0f)
            val alphaHolder =
                PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.5f, 1.0f)
            val rotationHolder =
                PropertyValuesHolder.ofFloat("rotation", 0f, 360f, 0f)
            ObjectAnimator.ofPropertyValuesHolder(iv, xHolder, alphaHolder, rotationHolder)
                .setDuration(3000)
                .start()
        }

        addButton("AnimatorSet 实现多个动画效果") { v ->
            val xAnimator = ObjectAnimator.ofFloat(iv, "scaleX", 1.0f, 0.5f, 1.0f)
            val yAnimator = ObjectAnimator.ofFloat(iv, "scaleY", 1.0f, 0.5f, 1.0f)
            val animator = AnimatorSet()
            animator.playTogether(xAnimator, yAnimator) // 一起执行
            animator.duration = 3000
            animator.start()
        }


        addButton("AnimatorSet 按顺序执行多个 playSequentially") { v ->
            val animator1 = ObjectAnimator.ofFloat(iv, "alpha", 1.0f, 0.5f, 1.0f)
            animator1.duration = 2000
            val xAnimator2 = ObjectAnimator.ofFloat(iv, "scaleX", 1.0f, 0.5f, 1.0f)
            val yAnimator2 = ObjectAnimator.ofFloat(iv, "scaleY", 1.0f, 0.5f, 1.0f)
            val scaleAnimator = AnimatorSet()
            scaleAnimator.playTogether(xAnimator2, yAnimator2)
            scaleAnimator.duration = 2000
            val animator3 = ObjectAnimator.ofFloat(iv, "rotation", 0f, 360f)
            animator3.duration = 2000
            val animator = AnimatorSet()
            animator.playSequentially(animator1, scaleAnimator, animator3) //Sequentially  按顺序执行
            animator.start()
        }

        addButton("AnimatorSet 控制动画执行顺序") { v ->
            val animator1 = ObjectAnimator.ofFloat(iv, "alpha", 1.0f, 0.5f, 1.0f)
            animator1.duration = 2000
            val xAnimator2 = ObjectAnimator.ofFloat(iv, "scaleX", 1.0f, 0.5f, 1.0f)
            xAnimator2.duration = 2000
            val yAnimator2 = ObjectAnimator.ofFloat(iv, "scaleY", 1.0f, 0.5f, 1.0f)
            yAnimator2.duration = 2000
            val animator3 = ObjectAnimator.ofFloat(iv, "rotation", 0f, 360f)
            animator3.duration = 2000
            val animator = AnimatorSet()
            // 执行顺序 animator1  -> xAnimator2和yAnimator2  -> animator3
            animator.play(xAnimator2).with(yAnimator2).after(animator1).before(animator3)
            animator.start()
        }


        addButton("Keyframes") { v ->
            val keyframe1 = Keyframe.ofFloat(0f, 1.0f)
            val keyframe2 = Keyframe.ofFloat(0.2f, 0.5f)
            val keyframe3 = Keyframe.ofFloat(0.4f, 1.0f)
            val keyframe4 = Keyframe.ofFloat(0.7f, 0f)
            val keyframe5 = Keyframe.ofFloat(1.0f, 1.0f)
            val xHolder = PropertyValuesHolder.ofKeyframe(
                "scaleX",
                keyframe1, keyframe2, keyframe3, keyframe4, keyframe5
            )
            val yHolder = PropertyValuesHolder.ofKeyframe(
                "scaleY",
                keyframe1, keyframe2, keyframe3, keyframe4, keyframe5
            )
            ObjectAnimator.ofPropertyValuesHolder(iv, xHolder, yHolder)
                .setDuration(3000)
                .start()
        }

        addButton("TypeEvaluator") { v ->
            val typeEvaluator: TypeEvaluator<Float> =
                object : TypeEvaluator<Float> {
                    var evaluator = FloatEvaluator()
                    override fun evaluate(
                        fraction: Float,
                        startValue: Float,
                        endValue: Float
                    ): Float {
                        L.d(TAG, "evaluate: $fraction    $startValue     $endValue")

                        return when {
                            fraction <= 0.2f -> evaluator.evaluate(fraction / 0.2f, 1.0f, 0.5f)
                            fraction <= 0.4f -> evaluator.evaluate(
                                (fraction - 0.2f) / 0.2f,
                                0.5f,
                                1.0f
                            )
                            fraction < 0.8f -> evaluator.evaluate(
                                (fraction - 0.4f) / 0.4f,
                                1.0f,
                                0f
                            )
                            fraction <= 1 -> evaluator.evaluate((fraction - 0.8f) / 0.2f, 0f, 1.0f)
                            else -> endValue
                        }
                    }
                }
            val xHolder =
                PropertyValuesHolder.ofObject("scaleX", typeEvaluator, 0f, 1.0f)
            val yHolder =
                PropertyValuesHolder.ofObject("scaleY", typeEvaluator, 0f, 1.0f)
            ObjectAnimator.ofPropertyValuesHolder(iv, xHolder, yHolder)
                .setDuration(3000)
                .start()
        }
    }

}
        