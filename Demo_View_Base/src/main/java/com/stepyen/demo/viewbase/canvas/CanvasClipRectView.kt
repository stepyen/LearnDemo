package com.stepyen.demo.viewbase.canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.stepyen.demo.base.AppManager
import com.stepyen.demo.viewbase.R

/**
 * date：2020/12/24
 * author：stepyen
 * description：
 *
 * 范围裁剪
 * canvas.clipRect
 *
 */
class CanvasClipRectView @JvmOverloads constructor(private val mContext: Context, private val mAttrs: AttributeSet? = null, private val mDefStyleAttr: Int = 0)
    : View(mContext, mAttrs, mDefStyleAttr){

    private val paint:Paint by lazy{
        Paint().apply {
            flags = Paint.ANTI_ALIAS_FLAG
            style = Paint.Style.FILL
        }
    }

    private val bitmap:Bitmap by lazy{
        BitmapFactory.decodeResource(AppManager.app?.resources, R.drawable.ic_batman)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.run {
            save()
            clipRect(0f,0f,200f,200f)
            drawBitmap(bitmap,0f,0f,paint)
            restore()
        }
    }

}