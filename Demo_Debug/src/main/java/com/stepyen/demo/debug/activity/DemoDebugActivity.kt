package com.stepyen.demo.debug.activity

import android.os.Build
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.base.utils.PermissionUtil
import com.stepyen.demo.base.utils.ServiceUtil
import com.stepyen.demo.debug.R
import com.stepyen.xutil.display.ScreenUtils
import kotlinx.android.synthetic.main.activity_demo_debug.*

/**
 * date：2020/12/12
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoDebugActivity)
class DemoDebugActivity:BasePageActivity(){

    override fun initView() {

        addButton("设置页面"){
            PermissionUtil.jumpToPermissionPage()
        }

        addView(R.layout.activity_demo_debug)

        deviceInfoTv.text = getDeviceInfo()


        testStatusBar()

    }


    /**
     * 测试状态栏
     */
    private fun testStatusBar() {
        val sb = StringBuilder()

        // 状态栏高度
        val statusBarRes = resources.getIdentifier("status_bar_height", "dimen", "android")
        val statusBarHeight = resources.getDimensionPixelSize(statusBarRes)
        sb.append("\n状态栏高度：$statusBarHeight\n")


        ServiceUtil.getWindowManager(this).defaultDisplay?.apply {
            sb.append("屏幕旋转角度：$rotation\n")
            sb.append("屏幕高度：$height\n")
            sb.append("屏幕宽度：$width\n")

        }


        L.d(sb.toString())
    }


    private fun getDeviceInfo():String {
        return StringBuilder()
            .append("品牌：").append(Build.BRAND).append("\n")
            .append("型号：").append(Build.MODEL).append("\n")
            .append("android 版本：").append(Build.VERSION.RELEASE).append("\n")
            .append("屏幕：").append("${ScreenUtils.getScreenWidth()}*${ScreenUtils.getScreenHeight()}").append("\n")
            .append("物理尺寸：").append("${ScreenUtils.getDevicePhysicalSize(this)}").append("\n")
            .toString()
    }
}