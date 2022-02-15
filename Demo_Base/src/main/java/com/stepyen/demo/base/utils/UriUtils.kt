package com.stepyen.demo.base.utils

import android.net.Uri
import android.text.TextUtils

/**
 * date：2022/2/15
 * author：stepyen
 * description：
 *
 */
class UriUtils {



    companion object{


        /**
         * uri中path部分，结尾是否是.gif
         */
        fun isPathEndWithGif(url:String?):Boolean {
            if (url == null || TextUtils.isEmpty(url)) {
                return false
            }

            val uri = Uri.parse(url)

            val path = uri.path?:""
            if (TextUtils.isEmpty(path)) {
                return false
            }

            return path.endsWith(".gif")

        }


    }
}