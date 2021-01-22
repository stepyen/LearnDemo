package com.stepyen.demo.viewcustom.activity

import android.graphics.RectF
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.viewcustom.R
import com.stepyen.xui.utils.DensityUtils
import kotlinx.android.synthetic.main.activity_guide_view.*


/**
 * date：2020/12/16
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.GuideViewActivity)
class GuideViewActivity:BasePageActivity() {

    override var TAG: String = "GuideView_TAG"

    var rectF = RectF()


    override fun initView() {


        addButton("获取view的位置信息"){
            rectF = getRectOnScreen(view)
            L.d(TAG,"view 的位置信息：${rectF?.left},${rectF?.top},${rectF?.right},${rectF?.bottom}" )
        }


        addButton("添加View"){
            val view = View(this@GuideViewActivity).apply {
                left = rectF.right.toInt()
                top = rectF.bottom.toInt()
                background = ContextCompat.getDrawable(this@GuideViewActivity,R.color.red)

                layoutParams = RelativeLayout.LayoutParams(DensityUtils.dp2px(30f), DensityUtils.dp2px(30f))
                parentRl.addView(this)
            }

        }

        addView(R.layout.activity_guide_view)

    }


    fun getRectOnScreen(view: View): RectF {
        if (view == null) {
            return RectF()
        }
        val result = RectF()
        val pos = IntArray(2)
        view.getLocationOnScreen(pos)
        result.left = pos[0].toFloat()
        result.top = pos[1].toFloat()
        result.right = result.left + view.measuredWidth
        result.bottom = result.top + view.measuredHeight
        return result
    }

}