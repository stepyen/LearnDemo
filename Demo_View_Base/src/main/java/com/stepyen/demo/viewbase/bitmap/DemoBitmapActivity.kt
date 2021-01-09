package com.stepyen.demo.viewbase.bitmap

import android.graphics.Bitmap
import android.os.Environment
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.common.CommonPath
import com.stepyen.demo.base.utils.BitmapUtil
import com.stepyen.demo.base.utils.FileUtil
import com.stepyen.demo.viewbase.R
import com.stepyen.xutil.display.ImageUtils
import java.io.File

/**
 * date：2020/12/15
 * author：stepyen
 * description：
 *
 */
class DemoBitmapActivity : BasePageActivity() {


    override fun initView() {

        addTagTextView("尺寸压缩后，再缩放到1024")

        addButton("图的分辨率：629*300") {

            val path = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "house.jpg"
            ).path

            val bitmap = compressAndScale(path)
            FileUtil.saveImageFile(CommonPath.imagePathDir, "", bitmap)

        }


        addButton("图的分辨率：3000*4000") {

            val path = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "book.jpg"
            ).path

            val bitmap = compressAndScale(path)
            FileUtil.saveImageFile(CommonPath.imagePathDir, "", bitmap)

        }



        addView(R.layout.activity_demo_bitmap)


    }

    /**
     * 尺寸压缩和缩放到指定高度
     *
     * 默认：1024
     *
     */
    private fun compressAndScale(path: String, target: Int = 1024): Bitmap? {

        var bitmap: Bitmap? = ImageUtils.getBitmap(path, target, target)
        var width = bitmap?.width ?: 0
        var height = bitmap?.height ?: 0

        if (width == 0 || height == 0) {
            return null
        }

        when {
            width > height -> {
                val ratio = (width / target.toFloat()).toFloat()
                width = target
                height = (height / ratio).toInt()
            }
            width < height -> {
                val ratio = (height / target.toFloat()).toFloat()
                width = (width / ratio).toInt()
                height = target
            }
            else -> {
                width = target
                height = target
            }
        }

        bitmap = ImageUtils.scale(bitmap, width, height, true)

        return bitmap

    }


}