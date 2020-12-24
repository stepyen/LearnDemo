package com.stepyen.demo.viewcustom.widget

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.stepyen.demo.viewcustom.R
import com.superdo.magina.autolayout.util.LayoutUtil

/**
 * date：2020/12/24
 * author：stepyen
 * description：
 *
 */
class DownloadProgressView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : View(mContext, mAttrs, mDefStyleAttr) {

    private var mWidth = 0

    private var mHeight = 0

    /**
     * 角度
     */
    private var angle = 0

    private var bgBitmap: Bitmap? = null
    private var frontBitmap: Bitmap? = null

    private val bgPaint: Paint by lazy {
        Paint()?.apply {
            style = Paint.Style.FILL
        }
    }
    private val frontPaint: Paint by lazy {
        Paint()?.apply {
            style = Paint.Style.FILL
        }
    }



    init {

        init(context, mAttrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.PictureLoadingView, 0, 0)
        ta?.run {

            getResourceId(R.styleable.PictureLoadingView_bgDrawable, -1)
                ?.takeIf { it != -1 }
                ?.let {
                    bgBitmap = BitmapFactory.decodeResource(mContext.resources, it)
                }

            getResourceId(R.styleable.PictureLoadingView_frontDrawable, -1)
                ?.takeIf { it != -1 }
                ?.let {
                    frontBitmap = BitmapFactory.decodeResource(mContext.resources, it)
                }

            getInt(R.styleable.PictureLoadingView_auto_width,20).apply {
                mWidth = LayoutUtil.unit2Px(this.toFloat())
            }
            getInt(R.styleable.PictureLoadingView_auto_height,20).apply {
                mHeight = LayoutUtil.unit2Px(this.toFloat())
            }

            recycle()
        }
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawBg(canvas)
        drawFront(canvas)
    }

    /**
     * 绘制背景
     */
    private fun drawBg(canvas: Canvas?) {
        bgBitmap?.let {
            canvas?.drawBitmap(bgBitmap, 0f, 0f, bgPaint)
        }
    }

    /**
     * 绘制前景
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun drawFront(canvas: Canvas?) {
        frontBitmap?.let {
            frontPaint.shader =
                BitmapShader(frontBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            canvas?.drawArc(0f, 0f, mWidth.toFloat(), mHeight.toFloat(), 180f, angle.toFloat(), true, frontPaint)
        }
    }


    /**
     * 设置百分比
     */
    fun setPercent(percent: Int) {
        var tempPercent = when {
            percent < 0 -> 0
            percent > 100 -> 100
            else -> percent
        }

        angle = (360 * (tempPercent / 100f)).toInt()

        invalidate()
    }


    override fun onDetachedFromWindow() {
        // 释放资源
        // ...

        bgBitmap = null
        frontBitmap = null

        super.onDetachedFromWindow()
    }
}