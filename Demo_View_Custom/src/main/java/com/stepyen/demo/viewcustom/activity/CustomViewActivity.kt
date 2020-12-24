package com.stepyen.demo.viewcustom.activity

import android.graphics.RectF
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.viewcustom.R
import com.stepyen.xui.utils.DensityUtils
import kotlinx.android.synthetic.main.activity_custom_view.*
import kotlinx.android.synthetic.main.activity_guide_view.*


/**
 * date：2020/12/16
 * author：stepyen
 * description：
 *
 */
class CustomViewActivity:BasePageActivity() {

    override var TAG: String = "CustomView_TAG"

    private var percent = 0

    override fun initView() {

        addView(R.layout.activity_custom_view)

        pictureLoadingViewBtn.setOnClickListener {
            percent += 10
            downloadProgressView.setPercent(percent)
        }


    }


}