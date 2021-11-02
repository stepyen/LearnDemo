package com.stepyen.demo.view.textview

import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.view.R
import com.stepyen.xutil.tip.ToastUtils
import kotlinx.android.synthetic.main.demo_activity_textview.*

/**
 * date：2020/12/24
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoTextViewActivity)
class DemoTextViewActivity : BasePageActivity() {





    override fun initView() {

        addView(R.layout.demo_activity_textview)

        clickableSpan()
        ellipsis()

    }


    private fun clickableSpan() {
        val ss = SpannableString("请阅读协议")
        ss.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                ToastUtils.toast("点击协议")
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(this@DemoTextViewActivity, R.color.red) // 设置字体颜色
                ds.isUnderlineText = false // 设置下划线
            }
        }, 3, 5, SpannableString.SPAN_INCLUSIVE_INCLUSIVE)

        // 设置字体颜色 这里设置的
        ss.setSpan(ForegroundColorSpan(ContextCompat.getColor(this@DemoTextViewActivity, R.color.blue)), 3, 5, SpannableString.SPAN_INCLUSIVE_INCLUSIVE)
        // 设置可点击
        tv_spannablestring_click.movementMethod = LinkMovementMethod.getInstance()
        // 点击后的高亮颜色
        tv_spannablestring_click.highlightColor = ContextCompat.getColor(this@DemoTextViewActivity, R.color.transparent)
        tv_spannablestring_click.text = ss
    }

    /**
     * 测试省略
     */
    private fun ellipsis() {
        ellipsisTv1.post {
            val ellipsisCount: Int = ellipsisTv1.layout.getEllipsisCount(ellipsisTv1.lineCount - 1)
            // 0表示没有省略
            if (ellipsisCount == 0) {
                L.d(TAG,"没有省略：0")
            }else{
                L.d(TAG,"省略了：$ellipsisCount")
            }
        }


        ellipsisTv2.ellipsisFunction = {it
            L.d(TAG,"test1: $it")
        }
        ellipsisTv2.text = "之前部署了Gitlab的代码托管平台和Jenkins"

        ellipsisTv3.ellipsisFunction = {it
            L.d(TAG,"test2: $it")
        }
        ellipsisTv3.text = "之前部署了Gitlab的代码托管平台和Jenkins的代码发布平台。通常是开发后的代码先推到Gitlab上管理，然后在Jenkins里通过脚本构建代码发布。"


    }
}
