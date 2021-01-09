package com.stepyen.demo.function.install

import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.function.R
import com.stepyen.xutil.app.PackageUtils

/**
 * date：2021/1/8
 * author：stepyen
 * description：学习-安装程序
 *
 */
class DemoInstallActivity : BasePageActivity() {


    override fun initView() {
        addView(R.layout.demo_activity_install)



        addButton("安装app"){
            val path = "/storage/emulated/0/Android/py.apk"

            val succeed = PackageUtils.installAppSilent(this,path)

        }

    }
}