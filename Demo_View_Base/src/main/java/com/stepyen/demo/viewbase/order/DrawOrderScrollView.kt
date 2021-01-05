package com.stepyen.demo.viewbase.order

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.ScrollView
import com.stepyen.demo.base.utils.L

/**
 * date：2021/1/5
 * author：stepyen
 * description：绘制顺序 - LinearLayout
 *
 */
class DrawOrderScrollView @JvmOverloads constructor(private val mContext: Context, private val mAttrs: AttributeSet? = null, private val mDefStyleAttr: Int = 0)
    : ScrollView(mContext, mAttrs, mDefStyleAttr){

    companion object{
        const val TAG = "DrawOrderScrollView_TAG"
    }


    init {

    }

    private val paint: Paint by lazy{
        Paint().apply {
            flags = Paint.ANTI_ALIAS_FLAG
            style = Paint.Style.FILL
            strokeWidth = 5f
            color = Color.BLACK
        }
    }

    /**
     * 绘制，总调度方法
     */
    override fun draw(canvas: Canvas?) {
        L.d(TAG,"draw   前")
        super.draw(canvas)
        L.d(TAG,"draw   后")
    }

    /**
     * 绘制自身
     */
    override fun onDraw(canvas: Canvas?) {
        L.d(TAG,"onDraw   前")
        super.onDraw(canvas)
        L.d(TAG,"onDraw   后")
    }

    /**
     * 绘制子View
     */
    override fun dispatchDraw(canvas: Canvas?) {
        L.d(TAG,"dispatchDraw   前")
        super.dispatchDraw(canvas)
        L.d(TAG,"dispatchDraw   后")
    }

    /**
     * 绘制前景
     *
     */
    override fun onDrawForeground(canvas: Canvas?) {
        L.d(TAG,"onDrawForeground   前")
        super.onDrawForeground(canvas)
        L.d(TAG,"onDrawForeground   后")
    }
}