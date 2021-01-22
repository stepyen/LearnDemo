package com.stepyen.demo.picture.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.common.CommonPath
import com.stepyen.demo.base.utils.FileUtil
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.picture.R
import com.stepyen.demo.picture.constant.DemoPictureConst
import com.stepyen.demo.picture.manager.TakePictureManager
import com.stepyen.demo.picture.utils.AlbumUtil
import com.stepyen.demo.zycropimage.Const
import com.stepyen.demo.zycropimage.cropimage.CropImageActivity
import com.stepyen.lib.avoidresult.AvoidOnResult
import com.stepyen.lib.fileprovider.FileProvider7
import com.stepyen.xutil.file.FileUtils
import kotlinx.android.synthetic.main.activity_demo_picture.*
import java.io.File

/**
 * date：2020/12/12
 * author：stepyen
 * description：系统的图片处理
 *
 */
@Route(path = PagePathHub.DemoPictureActivity)
class DemoPictureActivity : BasePageActivity() {

    private var path: String = ""

    override fun initView() {


        path = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
            "house.jpg"
        ).path

        addView(R.layout.activity_demo_picture)

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

        customZYCropBtn.setOnClickListener {
            L.d(DemoPictureConst.TAG, "文件路径：$path")
            if (!FileUtils.isFileExists(path)) {
                L.d(DemoPictureConst.TAG, "crop 失败，文件不存在")
                return@setOnClickListener
            }

            zyCrop(Uri.fromFile(File(path)))

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

            L.d(DemoPictureConst.TAG, "选取图片，resultCode：$resultCode")

            if (requestCode == DemoPictureConst.REQUEST_CODE_PICK && resultCode == Activity.RESULT_OK) {

                if (data != null) {
                    val uri = data.data
                    val imagePath = AlbumUtil.getPhotoPathFromAlbum(this@DemoPictureActivity, uri)

                    path = imagePath
                    resultIv.setImageURI(Uri.fromFile(File(path)))
                    L.d(DemoPictureConst.TAG, "选取图片路径：$imagePath")
                }
            }
        }
    }

    private fun takePicture() {
        TakePictureManager().startSystemTakePicture(this, { path ->
            this@DemoPictureActivity.path = path
        }, {})
    }

    private fun crop(path: String) {
        AvoidOnResult(this).startForResult(
            getCropIntent(path), DemoPictureConst.REQUEST_CODE_CROP
        ) { requestCode, resultCode, data ->

            L.d(DemoPictureConst.TAG, "裁剪，resultCode：$resultCode")

            val bitmap = data.getParcelableExtra<Bitmap>("data")
            resultIv.setImageBitmap(bitmap)

            FileUtil.saveImageFile(CommonPath.imagePathDir, "crop.jpg", bitmap)
        }
    }

    private fun getCropIntent(path: String): Intent {
        return Intent("com.android.camera.action.CROP")?.apply {
            FileProvider7.setIntentDataAndType(
                this@DemoPictureActivity,
                this,
                "image/*",
                File(path)
            )

            //就会调用裁剪，如果不设置，就会跳过裁剪的过程。
            putExtra("crop", "true")

            //剪裁框大小，不指定的话就可以随意设置大小
            if (Build.MANUFACTURER == "HUAWEI") {
                putExtra("aspectX", 9998)
                putExtra("aspectY", 9999)
            } else {
                putExtra("aspectX", 1)
                putExtra("aspectY", 1)
            }
            //生成的图片大小
            putExtra("outputX", 250)
            putExtra("outputY", 250)

            putExtra("scale", true)
            putExtra("outputFormat", "JPG")
            putExtra("noFaceDetection", true) //人脸识别
            putExtra("return-data", true) //是否要返回值
        }

    }

    private fun zyCrop(uri: Uri) {
        val intent = Intent(this, CropImageActivity::class.java)
        val bundle = Bundle()
//		bundle.putBoolean(CropImageActivity.CUSTOM_ICON, true);
//		bundle.putFloat(CropImageActivity.CUSTOM_ICON_ASPECT, 1);
//		bundle.putFloat(CropImageActivity.CUSTOM_ICON_MINWIDTH,UPLOAD_IMAGE_SIZE);
//		bundle.putBoolean(CropImageActivity.CUSTOM_ICON, true);
//		bundle.putFloat(CropImageActivity.CUSTOM_ICON_ASPECT, 1);
//		bundle.putFloat(CropImageActivity.CUSTOM_ICON_MINWIDTH,UPLOAD_IMAGE_SIZE);
        bundle.putParcelable(CropImageActivity.CUSTOM_URI, uri)
        bundle.putString(CropImageActivity.CUSTOM_SAVENAME, Const.CROP_FILE_NAME)
        bundle.putString(CropImageActivity.CUSTOM_SAVEPATH, CommonPath.imagePathDir)
        bundle.putFloat(CropImageActivity.CUSTOM_RATIO, 1.0f)
        bundle.putInt(CropImageActivity.CUSTOM_MINWIDTH, 300)
//		bundle.putString(CropImageActivity.CUSTOM_ICON_PATH, PERSONALCENTER_CAPTURE_PATH);
//		bundle.putString(CropImageActivity.CUSTOM_ICON_NAME, CUSTOM_IMAGE_FILE);
//		bundle.putString(CropImageActivity.CUSTOM_ICON_PATH, PERSONALCENTER_CAPTURE_PATH);
//		bundle.putString(CropImageActivity.CUSTOM_ICON_NAME, CUSTOM_IMAGE_FILE);
        intent.putExtras(bundle)
        startActivityForResult(intent, Const.REQUEST_CROP_IMAGE)
    }



}