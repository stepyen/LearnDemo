package com.stepyen.demo.viewbase.measure

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.stepyen.demo.base.utils.L

/**
 * date：2021/1/18
 * author：stepyen
 * description：
 *
 */
class MeasureView @JvmOverloads constructor(private val mContext: Context, private val mAttrs: AttributeSet? = null, private val mDefStyleAttr: Int = 0)
    : View(mContext, mAttrs, mDefStyleAttr){

    companion object{
        const val TAG = "MeasureView_TAG"
    }

    private val paint: Paint by lazy{
        Paint().apply {
            style = Paint.Style.FILL
            strokeWidth = 5f
            color = Color.BLACK
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        L.d(TAG,"widthMode: $widthMode")
        L.d(TAG,"heightMode: $heightMode")
        L.d(TAG,"widthSize: $widthSize")
        L.d(TAG,"heightSize: $heightSize")

        when (widthMode) {
            MeasureSpec.AT_MOST->{

            }
            MeasureSpec.EXACTLY->{

            }
            MeasureSpec.UNSPECIFIED->{

            }
        }

        when (heightMode) {
            MeasureSpec.AT_MOST->{

            }
            MeasureSpec.EXACTLY->{

            }
            MeasureSpec.UNSPECIFIED->{

            }
        }

        setMeasuredDimension(widthSize,heightSize)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(100f,100f,50f,paint)

    }

}