package com.stepyen.demo.app.drawable

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable

/**
 * date：2021/1/15
 * author：stepyen
 * description：
 *
 */
class TestDrawable :Drawable() {
    override fun draw(canvas: Canvas) {
    }

    override fun setAlpha(alpha: Int) {
    }

    override fun getOpacity(): Int {
        return PixelFormat.OPAQUE
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }

}