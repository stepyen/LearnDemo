package com.stepyen.demo.picture.manager

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import com.stepyen.demo.base.App
import com.stepyen.demo.base.common.CommonPath
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.picture.constant.DemoPictureConst
import com.stepyen.lib.avoidresult.AvoidOnResult
import com.stepyen.lib.fileprovider.FileProvider7
import java.io.File
import java.io.FileNotFoundException
import java.text.SimpleDateFormat
import java.util.*

/**
 * date：2020/11/24
 * author：stepyen
 * description：拍照
 *
 */
class TakePictureManager {

    /**
     * 图片地址
     */
    var imagePath = ""


    /**
     * 打开系统拍照
     */
    fun startSystemTakePicture(activity: Activity,succeedAction:(String)->Unit,failAction:()->Unit )  {

        imagePath = createImagePath()
        L.d(DemoPictureConst.TAG, "图片地址：$imagePath")
        val intent = getSystemTakePictureIntent(imagePath)

        AvoidOnResult(activity).startForResult(intent, DemoPictureConst.REQUEST_CODE_TAKE_PICKTURE) { requestCode, resultCode, data ->
            when (requestCode) {
                DemoPictureConst.REQUEST_CODE_TAKE_PICKTURE -> {

                    L.d(DemoPictureConst.TAG, "拍照，resultCode：$resultCode")

                    if (resultCode == Activity.RESULT_OK) {
                        L.d(DemoPictureConst.TAG, "拍照成功")
                        saveIntoPhotoAlbum(imagePath)
                        succeedAction.invoke(imagePath)
                    } else {
                        L.d(DemoPictureConst.TAG, "拍照失败")
                        failAction?.invoke()
                    }
                }
            }
        }

    }


    /**
     * 获取系统拍照 Intent
     */
    private fun getSystemTakePictureIntent(path: String): Intent {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
             intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
             intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
         }

        val uri = FileProvider7.getUriForFile(App.get(), File(path))

        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)

        return intent
    }

    /**
     * 创建图片地址
     */
    private fun createImagePath(): String {
        val format = SimpleDateFormat("yyyyMMddHHmmss")
        val date = Date(System.currentTimeMillis())
        val file = File("${CommonPath.imagePathDir}",
                "${format.format(date)}.jpg")
        if (!file.parentFile.exists()) {
            file.parentFile.mkdirs()
        }
        return file.path
    }


    /**
     * 保存到图库
     */
    private fun saveIntoPhotoAlbum(path: String) {
        val file = File(path)
        // 文件插入系统图库
        try {
            MediaStore.Images.Media.insertImage(App.get().contentResolver,
                    file.absolutePath, file.name, null)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        // 通知图库更新
        App.get().sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)))
    }
}