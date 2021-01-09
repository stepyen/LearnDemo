package com.stepyen.demo.function.permission

import android.Manifest
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.xutil.tip.ToastUtils

/**
 * date：2021/1/8
 * author：stepyen
 * description：学习-权限申请
 *
 */
class DemoPermissionActivity : BasePageActivity() {


    override fun initView() {

        addButton("正常方式，检查录音权限"){
            ToastUtils.toast("${PermissionUtils.hasPermission(Manifest.permission.RECORD_AUDIO)}")
        }


    }
}