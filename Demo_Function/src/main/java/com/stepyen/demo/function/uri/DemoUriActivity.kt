package com.stepyen.demo.function.uri

import android.net.Uri
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.function.R
import kotlinx.android.synthetic.main.demo_activity_uri.*

/**
 *
 */
@Route(path = PagePathHub.DemoUriActivity)
class DemoUriActivity : BasePageActivity() {


    override fun initView() {

        addView(R.layout.demo_activity_uri)
        testUri()
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


}
