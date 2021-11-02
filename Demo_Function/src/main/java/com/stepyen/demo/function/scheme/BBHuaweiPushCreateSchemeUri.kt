package com.stepyen.demo.function.scheme

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.util.Log
import org.json.JSONObject
import java.net.URLDecoder

/**
 * date：2021/4/10
 * author：stepyen
 * description：
 *
case "openActivity"://打开活动
openActivity();
return;
case "openBrowser"://打开浏览器
openBrowser();
return;
case "openApp"://打开app
openApp();
return;
case "openHome"://打开应用
openHome();
return;
case "openSubscribe"://打开付费订阅
openSubscribe();
return;
 *
 */
class BBHuaweiPushCreateSchemeUri {

    companion object {

        const val TAG = "BBHuaweiPushCreateSchemeUri"

//        private const val PACKAGE_NAME = "babybus-world.com"
//        private const val PACKAGE_NAME = "com.sinyee.babybus.shopping"
        private const val PACKAGE_NAME = "com.stepyen.test"
//        private const val PACKAGE_NAME = "com.stepyen.forest"

        var testUri = ""


        /**
         * 外部浏览器
         */
        fun outBrower() {
            val url = "https://shop.huawei.com/tr/product/huawei-matepad"
//            val url = "https://www.baidu.com/"

            val pageJo = JSONObject().apply {
                put("url", url)
            }

            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "Huawei")
                put("uri", "babybus://push/openBrowser?${pageJo.toString()}")
            }

            val uri = "babybus://hwpush/push/openPush?$pushJo"

            Log.d(TAG," 外部浏览器：$uri")

            explicitUri("外部浏览器 URI_INTENT_SCHEME:", uri)
        }


        /**
         * 活动页面
         */
        fun openActivity() {

            val pageJo = JSONObject().apply {
                put("id", "123")
                put("img", "")
                put("type", "2")
                put("url", "https://www.baidu.com/")
                put("code", "1")
            }

            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "Huawei")
                put("uri", "babybus://push/openActivity?${pageJo.toString()}")
            }


            val uri = "babybus://hwpush/push/openPush?$pushJo"

            Log.d(TAG," 活动页面：$uri")

            explicitUri("活动页面 URI_INTENT_SCHEME:", uri)
        }

        /**
         * 打开付费订阅
         */
        fun openSubscribe() {

            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "Huawei")
                put("uri", "babybus://push/openSubscribe")
            }

            val uri = "babybus://hwpush/push/openPush?$pushJo"



            Log.d(TAG," 付费订阅：$uri")

            explicitUri("付费订阅 URI_INTENT_SCHEME:", uri)
        }



        /**
         * 显示uri
         */
        private fun explicitUri(type:String,pushUri:String) {
            val intent = Intent().apply {
                action = Intent.ACTION_VIEW
//                putExtra("GETUI_OPEN_URL",pushUri)
                data = Uri.parse(pushUri)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }

            testUri = URLDecoder.decode(intent.toUri(Intent.URI_INTENT_SCHEME).toString(), "UTF-8")


            Log.d(TAG,"$type---->$testUri}")

        }


    }




}