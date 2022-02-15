package com.stepyen.demo.function.uri

import android.net.Uri
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.base.utils.UriUtils
import com.stepyen.demo.function.R
import kotlinx.android.synthetic.main.demo_activity_uri.*

/**
 *
 */
@Route(path = PagePathHub.DemoUriActivity)
class DemoUriActivity : BasePageActivity() {

    override var TAG = "DemoUriActivity_TAG"

    override fun initView() {

        addView(R.layout.demo_activity_uri)
        testUri()
        testIsPathEndWithGif()
    }


    private fun testUri() {
        val sb = StringBuilder()

        val uriStr = "http://www.baidu.com:8080/wenku/jiatiao.html?id=123456&name=jack#fragment=123"
        val uri = Uri.parse(uriStr)

        sb.append("Uri: $uriStr\n")
        sb.append("\n")
        sb.append("Scheme: " + uri.scheme + "\n")
        sb.append("Host: " + uri.host + "\n")
        sb.append("Port: " + uri.port + "\n")
        sb.append("Path: " + uri.path + "\n")
        sb.append("Query: " + uri.query + "\n")
        sb.append("Fragment: " + uri.fragment + "\n")
        sb.append("\n\n")
        sb.append("获取每一部分的Path: \n")
        val pathSegments = uri.pathSegments
        for (path in pathSegments) {
            sb.append(path + "\n")
        }
        sb.append("\n")
        tv_uri.text = sb.toString()

    }

    private fun testIsPathEndWithGif() {

        fun test(url:String?) {
            L.d(TAG, "$url path结尾是否是.gif：${UriUtils.isPathEndWithGif(url)}")
        }

        test("https://example.com")
        test("https://example.com/image.gif")
        test("https://example.com/image.png")
        test("https://example.com?type=202&sckId=71")
        test("https://example.com/image.gif?type=202&sckId=71")


    }



}
