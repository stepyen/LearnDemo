package com.stepyen.demo.function.scheme

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.orhanobut.logger.Logger
import org.json.JSONObject
import java.net.URLDecoder

/**
 * date：2020-03-12
 * author：stepyen
 * description：生成 sheme uri
 *
 */
class BBGetuiCreateSchemeUri {

    companion object{

        const val TAG = "BBGetui"

//        const val PACKAGE_NAME = "com.kid58.tiyong.characters"
        private const val PACKAGE_NAME = "com.sinyee.babybus.talk2kiki"


        /**
         * 首页
         */
        fun home() {


            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "getui")
                put("uri", "babybus://push/openHome")
            }


            val jo = JSONObject().apply {
                put("title", "首页")
                put("content", "通知内容")
                put("isVibrate", "1")
                put("isSound", "1")
                put("extra", "babybus://push/openPush?$pushJo")
            }


            Log.d(TAG," 首页 $jo")
            Log.d(TAG," 首页 extra " + jo.getString("extra"))

        }

        /**
         * 游戏
         */
        fun game() {

            val gameJo = JSONObject().apply {
                put("type", "baike")
                put("data", "https://www.baidu.com/")
            }


            val pageJo = JSONObject().apply {
                put("url", gameJo.toString())
            }


            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "getui")
                put("uri", "babybus://push/openGame?${pageJo.toString()}")
            }
            

            val jo = JSONObject().apply {
                put("title", "游戏内页面")
                put("content", "通知内容")
                put("isVibrate", "1")
                put("isSound", "1")
                put("extra", "babybus://push/openPush?$pushJo")
            }

            Log.d(TAG," 游戏内页面 $jo")
            Log.d(TAG," 游戏内页面 extra " + jo.getString("extra"))

        }

        /**
         * 外部浏览器
         */
        fun outBrower() {

            val pageJo = JSONObject().apply {
                put("url", "https://www.baidu.com/")
            }


            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "getui")
                put("uri", "babybus://push/openBrowser?${pageJo.toString()}")
            }


            val jo = JSONObject().apply {
                put("title", "外部浏览器")
                put("content", "通知内容")
                put("isVibrate", "1")
                put("isSound", "1")
                put("extra", "babybus://push/openPush?$pushJo")
            }


            Log.d(TAG," 外部浏览器 $jo")
            Log.d(TAG," 外部浏览器 extra " + jo.getString("extra"))
        }
        /**
         * 内部浏览器
         */
        fun innerBrower() {

            val pageJo = JSONObject().apply {
                put("url", "https://www.luoxia.com/")
            }


            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "getui")
                put("uri", "babybus://push/openActivity?${pageJo.toString()}")
            }


            val jo = JSONObject().apply {
                put("title", "内部浏览器")
                put("content", "通知内容")
                put("isVibrate", "1")
                put("isSound", "1")
                put("extra", "babybus://push/openPush?$pushJo")
            }


            Log.d(TAG," 内部浏览器 $jo")
            Log.d(TAG," 内部浏览器 extra " + jo.getString("extra"))
        }


        /**
         * 首页
         */
        fun homeIntentUri() {
            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "getui")
                put("uri", "babybus://push/openHome")
            }

            val homeUri = "babybus://push/openPush?${pushJo.toString()}"


            explicitUri("首页 intent uri ",homeUri)

        }


        /**
         * 游戏
         */
        fun gameIntentUri() {
            val gameJo = JSONObject().apply {
                put("type", "baike")
                put("data", "https://www.baidu.com/")
            }

            val pageJo = JSONObject().apply {
                put("url", gameJo.toString())
            }


            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "getui")
                put("uri", "babybus://push/openGame?${pageJo.toString()}")
            }

            val homeUri = "babybus://push/openPush?${pushJo.toString()}"

            explicitUri("游戏 intent uri ",homeUri)

        }


        /**
         * 外部浏览器
         */
        fun outBrowerIntentUri() {
            val pageJo = JSONObject().apply {
                put("url", "https://www.baidu.com/")
            }


            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "getui")
                put("uri", "babybus://push/openBrowser?${pageJo.toString()}")
            }

            val homeUri = "babybus://push/openPush?${pushJo.toString()}"

            explicitUri("外部浏览器 intent uri ",homeUri)

        }

        /**
         * 内部浏览器
         */
        fun innerBrowerIntentUri() {
            val pageJo = JSONObject().apply {
                put("url", "https://www.luoxia.com/")
            }


            val pushJo = JSONObject().apply {
                put("id", "123")
                put("type", "getui")
                put("uri", "babybus://push/openActivity?${pageJo.toString()}")
            }

            val homeUri = "babybus://push/openPush?${pushJo.toString()}"

           explicitUri("内部浏览器 intent uri ",homeUri)

        }


        /**
         * 显示uri
         */
        private fun explicitUri(type:String,pushUri:String) {
            val intent = Intent().apply {
                `package` = PACKAGE_NAME
                component = ComponentName(`package`,"com.babybus.plugin.getui.GetuiPushActivity")
                action = Intent.ACTION_VIEW
                putExtra("GETUI_OPEN_URL",pushUri)
            }


            Log.d(TAG,"$type---->${URLDecoder.decode(intent.toUri(Intent.URI_INTENT_SCHEME).toString(), "UTF-8")}")

        }
    }
}