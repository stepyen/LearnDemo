package com.stepyen.demo.viewbase.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * date：2020/12/24
 * author：stepyen
 * description：
 *
 */
class CanvasLinesView @JvmOverloads constructor(private val mContext: Context, private val mAttrs: AttributeSet? = null, private val mDefStyleAttr: Int = 0)
    : View(mContext, mAttrs, mDefStyleAttr){

    private val paint:Paint by lazy{
        Paint().apply {
            style = Paint.Style.FILL
            strokeWidth = 5f
            color = Color.BLACK
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        绘制两条线：按四个为间隔

        // 只能是4的倍数个
        val lines = floatArrayOf(0f,0f,100f,100f,200f,100f,200f,200f)

        canvas?.drawLines(lines,paint)

        /**
         * 2：跳过两个，如 0f,0f
         * 4：绘制4个值，如 （100f,100f）,（200f,100f）
         */
//        canvas?.drawLines(lines,2,4,paint)



    }

}