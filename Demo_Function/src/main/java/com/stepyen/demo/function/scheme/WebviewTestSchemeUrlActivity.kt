package com.stepyen.demo.function.scheme

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.text.Html
import android.text.method.LinkMovementMethod
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.function.R
import com.stepyen.xutil.tip.ToastUtils
import kotlinx.android.synthetic.main.activity_url_scheme.*

/**
 * date：2021/1/9
 * author：stepyen
 * description：网页测试 SchemeUrl 跳转到其他app
 *
 */
@Route(path = PagePathHub.WebviewTestSchemeUrlActivity)
class WebviewTestSchemeUrlActivity:BasePageActivity() {
    companion object {
        const val test_uri = "stepyen://xiaoming@host.com/record/path?address=china&phone=1875912233#fragment=fragment123"

        //妙学识字-游戏内-商城界面
        const val characters_game_uri = "com.kid58.tiyong.characters://{\"type\":\"https://beta-wx.kid58.com/double12/index\",\"data\":\"\"}"

    }

    override fun initView() {
        addView(R.layout.activity_url_scheme)

        btn_jump_input.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(et_uri.text.toString().trim { it <= ' ' })
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                ToastUtils.toast("Activity 未找到")
            }
        }


        tv_uri.text = "测试uri: \n$test_uri"
        btn_jump_fixation.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(test_uri)
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                ToastUtils.toast("Activity 未找到")
            }
        }



        try {
            val sb = StringBuilder()
            sb.append("<a href='")
            sb.append(test_uri)
            sb.append("'>点击跳转</a>")
            tv_test_html_uri.text = "网页测试 uri：\n$sb"
            tv_html_uri.text = Html.fromHtml(sb.toString())
            tv_html_uri.movementMethod = LinkMovementMethod.getInstance()
        } catch (e: ActivityNotFoundException) {
            ToastUtils.toast("Activity 未找到")
        }

        try {


            val sb = StringBuilder()
            sb.append("<a href='")
            sb.append(characters_game_uri)
            sb.append("'>点击跳转</a>")
            tv_test_babybus_uri.text = "网页测试 uri：\n$sb"
            tv_babybus_uri.text = Html.fromHtml(sb.toString())
            tv_babybus_uri.movementMethod = LinkMovementMethod.getInstance()
        } catch (e: Exception) {
            e.printStackTrace()
        }





        try {
            val uri = "stepyen://path"
            val sb = StringBuilder()
            sb.append("<a href='")
            sb.append(uri)
            sb.append("'>跳转到 测试demo 下的 scheme 页面</a>")

            addTextView(Html.fromHtml(sb.toString()))?.apply {
                movementMethod = LinkMovementMethod.getInstance()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }



        bb_word_test_uri_btn.setOnClickListener {
            startActivity(Intent(Uri.parse(BBHuaweiPushCreateSchemeUri.testUri).toString()))
        }
    }


}