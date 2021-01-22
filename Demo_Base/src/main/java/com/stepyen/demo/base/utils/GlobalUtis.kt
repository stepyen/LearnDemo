package com.stepyen.demo.base.utils

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter

/**
 * date：2021/1/22
 * author：stepyen
 * description：
 *
 */
class GlobalUtis {



    companion object{
        /**
         * 跳转页面
         */
        @JvmOverloads
        fun gotoPage(path: String, context: Context? = null, bundle: Bundle? = null, requestCode:Int?=null) {

            var postcard = ARouter
                .getInstance()
                .build(path)
                .with(bundle)
            if (context == null) {
                postcard.navigation()
            } else {
                if (requestCode == null) {
                    postcard.navigation(context)
                }else{
                    postcard.navigation(context as Activity,requestCode)
                }

            }
        }

    }
}