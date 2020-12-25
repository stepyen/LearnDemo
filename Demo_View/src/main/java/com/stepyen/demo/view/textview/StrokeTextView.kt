package com.stepyen.demo.view.textview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import com.stepyen.demo.view.R
import com.superdo.magina.autolayout.util.LayoutUtil
import com.superdo.magina.autolayout.widget.AutoTextView

/**
 * date：2020/12/25
 * author：stepyen
 * description：
 *
 */
class StrokeTextView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : AutoTextView(mContext, mAttrs, mDefStyleAttr) {
    init {
        init(mContext, mAttrs)
    }

    private var strokeColor = Color.BLACK
    private var strokeWidth = 0f

    private fun init(context: Context, attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.StrokeTextView, 0, 0)
        ta?.run {

            strokeColor = getColor(R.styleable.StrokeTextView_stv_stroke_color, Color.BLACK)
            strokeWidth = getFloat(R.styleable.StrokeTextView_stv_stroke_width, 0f)
            strokeWidth = LayoutUtil.getUnitSize(strokeWidth)
            recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        paint.apply {
            paint.style = Paint.Style.STROKE
            color = strokeColor
            strokeWidth = strokeWidth
        }
        super.onDraw(canvas)
    }


}
