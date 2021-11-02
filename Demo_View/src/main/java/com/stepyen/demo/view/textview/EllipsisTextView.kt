package com.stepyen.demo.view.textview

import android.content.Context
import android.graphics.Canvas
import android.text.TextUtils
import android.util.AttributeSet
import com.superdo.magina.autolayout.widget.AutoTextView

/**
 * date：2021/3/11
 * author：stepyen
 * description：省略TextView
 * 功能：
 * 1、文本末尾是否有省略，会回调 ellipsisFunction
 *
 */
class EllipsisTextView @JvmOverloads constructor(
    private val mContext: Context,
    private val mAttrs: AttributeSet? = null,
    private val mDefStyleAttr: Int = 0
) : AutoTextView(mContext, mAttrs, mDefStyleAttr) {

    /**
     * 是否省略字符回调
     *
     */
    var ellipsisFunction: ((Boolean) -> Unit)? = null

    init {
        ellipsize = TextUtils.TruncateAt.END
        maxLines = 1
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        post {
            // 获取最后一行文本是否省略
            val ellipsisCount = layout.getEllipsisCount(lineCount - 1)
            ellipsisFunction?.invoke(ellipsisCount != 0)
        }
    }

}