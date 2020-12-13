package com.stepyen.demo.picture.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.ImageView
import com.stepyen.demo.base.App
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.picture.R
import com.stepyen.demo.picture.constant.DemoPictureConst
import com.stepyen.demo.picture.manager.TakePictureManager
import com.stepyen.demo.picture.utils.AlbumUtil
import com.stepyen.lib.avoidresult.AvoidOnResult
import com.stepyen.lib.fileprovider.FileProvider7
import com.stepyen.xutil.file.FileUtils
import kotlinx.android.synthetic.main.activity_demo_system_picture.*
import java.io.File

/**
 * date：2020/12/12
 * author：stepyen
 * description：系统的图片处理
 *
 */
class DemoSystemPictureActivity : BasePageActivity() {

    private var path: String = ""

    override fun initView() {


        addView(R.layout.activity_demo_system_picture)

        takePictureBtn.setOnClickListener {
            takePicture()
        }
        pickBtn.setOnClickListener {
            pick()
        }

        cropBtn.setOnClickListener {
            L.d(DemoPictureConst.TAG, "文件路径：$path")
            if (FileUtils.isFileExists(path)) {
                crop(path)
            } else {
                L.d(DemoPictureConst.TAG, "crop 失败，文件不存在")
            }

        }

        customCropBtn.setOnClickListener {
            L.d(DemoPictureConst.TAG, "文件路径：$path")
            if (!FileUtils.isFileExists(path)) {
                L.d(DemoPictureConst.TAG, "crop 失败，文件不存在")
                return@setOnClickListener
            }

            // 裁剪

        }

    }

    private fun pick() {
        val intent =
            Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        AvoidOnResult(this).startForResult(
            intent,
            DemoPictureConst.REQUEST_CODE_PICK
        ) { requestCode,
            resultCode,
            data ->

            if (requestCode == DemoPictureConst.REQUEST_CODE_PICK && resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    val uri = data.data
                    val imagePath = AlbumUtil.getPhotoPathFromAlbum(this@DemoSystemPictureActivity, uri)

                    path = imagePath
                    resultIv.setImageURI(Uri.fromFile(File(path)))
                    L.d(DemoPictureConst.TAG, "选取图片路径：$imagePath")
                }
            }
        }
    }

    private fun takePicture() {
        TakePictureManager().startSystemTakePicture(this, { path ->
            this@DemoSystemPictureActivity.path = path
        }, {})
    }

    private fun crop(path: String) {
        AvoidOnResult(this).startForResult(
            getCropIntent(path), DemoPictureConst.REQUEST_CODE_CROP
        ) { requestCode, resultCode, data ->

            val bitmap = data.getParcelableExtra<Bitmap>("data")
            resultIv.setImageBitmap(bitmap)

        }
    }

    private fun getCropIntent(path: String): Intent {
        return Intent("com.android.camera.action.CROP")?.apply {
            FileProvider7.setIntentDataAndType(
                this@DemoSystemPictureActivity,
                this,
                "image/*",
                File(path),
                true
            )
            putExtra("crop", "true") //就会调用裁剪，如果不设置，就会跳过裁剪的过程。
            //剪裁框大小，不指定的话就可以随意设置大小
            if (Build.MANUFACTURER == "HUAWEI") {
                putExtra("aspectX", 9998)
                putExtra("aspectY", 9999)
            } else {
                putExtra("aspectX", 1)
                putExtra("aspectY", 1)
            }
            //输出的图片，返回的是像素大小
            putExtra("outputX", 250)
            putExtra("outputY", 250)
            //上面两个值会生成一个bitmap
            putExtra("scale", true)
            putExtra("outputFormat", "JPG")
            putExtra("noFaceDetection", true) //人脸识别
            putExtra("return-data", true) //是否要返回值，这个一定要
        }

    }

}