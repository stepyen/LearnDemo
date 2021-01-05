package com.stepyen.demo.viewbase.order

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.LinearLayout

/**
 * date：2021/1/5
 * author：stepyen
 * description：绘制红点，在绘制 dispatchDraw 之后
 *
 */
class DrawRedAfterDispatchDrawView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : LinearLayout(mContext, mAttrs, mDefStyleAttr) {

    companion object {
        const val TAG = "DrawOrderLinearLayout_TAG"
    }

    private val paint: Paint by lazy {
        Paint().apply {
            flags = Paint.ANTI_ALIAS_FLAG
            style = Paint.Style.FILL
            color = Color.parseColor("#B3FF5722")
        }
    }



    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)

        canvas?.drawCircle(100f,200f,10f,paint)
        canvas?.drawCircle(300f,180f,20f,paint)
        canvas?.drawCircle(110f,350f,20f,paint)
        canvas?.drawCircle(300f,400f,25f,paint)

    }


    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)

    }

}

