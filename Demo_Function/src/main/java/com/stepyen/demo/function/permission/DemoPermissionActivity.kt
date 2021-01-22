package com.stepyen.demo.function.permission

import android.Manifest
import androidx.core.app.ActivityCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.xutil.tip.ToastUtils

/**
 * date：2021/1/8
 * author：stepyen
 * description：学习-权限申请
 *
 */
@Route(path = PagePathHub.DemoPermissionActivity)
class DemoPermissionActivity : BasePageActivity() {
    override var TAG: String = "DemoPermissionActivity_TAG"
    companion object{
        const val REQUEST_AUDIO = 1000
    }


    override fun initView() {

        addButton("正常方式，检查录音权限"){
            ToastUtils.toast("${PermissionUtils.hasPermission(Manifest.permission.RECORD_AUDIO)}")
        }


        addButton("mainActivity页面请求权限"){
            this?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(Manifest.permission.RECORD_AUDIO),
                    REQUEST_AUDIO
                )
            }

        }


    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        L.d(TAG,"requestCode : $requestCode")
        L.d(TAG,"permissions length: ${permissions.size}")
        L.d(TAG,"grantResults length: ${grantResults.size}")

        when(requestCode) {
            REQUEST_AUDIO->{

            }
        }
    }









}