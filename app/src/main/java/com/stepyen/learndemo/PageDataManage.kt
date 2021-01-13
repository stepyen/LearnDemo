package com.stepyen.learndemo

import com.stepyen.demo.androidmanifest.configchanges.DemoConfigChangesActivity
import com.stepyen.demo.androidmanifest.metadata.DemoMetaDataActivity
import com.stepyen.demo.androidmanifest.launchmode.DemoLaunchModeActivity
import com.stepyen.demo.androidmanifest.max_aspect.DemoMaxAspectActivity
import com.stepyen.demo.androidmanifest.screen_orientation.DemoScreenOrientationActivity
import com.stepyen.demo.androidmanifest.windowsoftinputmode.DemoWindowSoftInputModeActivity
import com.stepyen.demo.animation.activity.DemoFrameAnimationActivity
import com.stepyen.demo.animation.activity.DemoPropertyAnimotionActivity
import com.stepyen.demo.animation.activity.DemoTestAnimationActivity
import com.stepyen.demo.animation.activity.DemoTweenAnimotionActivity
import com.stepyen.demo.app.resource.DemoResourceActivity
import com.stepyen.demo.base.PageListActivity
import com.stepyen.demo.debug.activity.DemoDebugActivity
import com.stepyen.demo.function.countdown.DemoCountDownActivity
import com.stepyen.demo.function.handle.DemoHandleActivity
import com.stepyen.demo.function.install.DemoInstallActivity
import com.stepyen.demo.function.json.DemoJsonActivity
import com.stepyen.demo.function.permission.DemoPermissionActivity
import com.stepyen.demo.function.scheme.DemoSchemeUrlActivity
import com.stepyen.demo.function.softinput.DemoSoftInputActivity
import com.stepyen.demo.function.uri.DemoUriActivity
import com.stepyen.demo.picture.activity.DemoPictureActivity
import com.stepyen.demo.thirdlab.autolayout.DemoAutoLayoutActivity
import com.stepyen.demo.thirdlab.gifdrawable.DemoGifDrawableActivity
import com.stepyen.demo.thirdlab.glide.DemoGlideActivity
import com.stepyen.demo.view.dialog.DemoDialogActivity
import com.stepyen.demo.view.imageview.DemoImageViewActivity
import com.stepyen.demo.view.popwindow.DemoPopWindowActivity
import com.stepyen.demo.view.recycleview.RecycleViewActivity
import com.stepyen.demo.view.textview.DemoTextViewActivity
import com.stepyen.demo.viewbase.bitmap.DemoBitmapActivity
import com.stepyen.demo.viewbase.cover.DemoViewCoverActivity
import com.stepyen.demo.viewbase.canvas.DemoViewCanvasActivity
import com.stepyen.demo.viewbase.order.DemoDrawOrderActivity
import com.stepyen.demo.viewbase.paint.DemoViewPaintActivity
import com.stepyen.demo.viewcustom.activity.CustomViewActivity
import com.stepyen.demo.viewcustom.activity.GuideViewActivity
import com.stepyen.demo.base.bean.PageBean
import com.stepyen.demo.view.notification.DemoNotificationActivity

/**
 * date：2020-02-12
 * author：stepyen
 * description：页面数据管理
 *
 */
object PageDataManage {
    val data: LinkedHashMap<PageBean, ArrayList<PageBean>> = LinkedHashMap<PageBean, ArrayList<PageBean>>()

    init {


        put(
            "debug",
            arrayListOf<PageBean>().apply {

                add(PageBean("设备信息", DemoDebugActivity::class.java))

            })



        put(
            "App",
            arrayListOf<PageBean>().apply {

                add(PageBean("资源", DemoResourceActivity::class.java))

            })


        put(
            "配置清单",
            arrayListOf<PageBean>().apply {

                add(PageBean("configChanges", DemoConfigChangesActivity::class.java))
                add(PageBean("launchMode", DemoLaunchModeActivity::class.java))
                add(PageBean("windowSoftInputMode", DemoWindowSoftInputModeActivity::class.java))
                add(PageBean("screenOrientation", DemoScreenOrientationActivity::class.java))
                add(PageBean("meta-data", DemoMetaDataActivity::class.java))
                add(PageBean("max_aspect", DemoMaxAspectActivity::class.java))

            })

        put(
            "组件",
            arrayListOf<PageBean>().apply {

                add(PageBean("Activity"))
                add(PageBean("别名", DemoLaunchModeActivity::class.java))
                add(PageBean("生命周期", DemoLaunchModeActivity::class.java))
                add(PageBean("屏幕方向", DemoLaunchModeActivity::class.java))


                add(PageBean("ContentProvider"))


                add(PageBean("Intent"))
                add(PageBean("1", DemoLaunchModeActivity::class.java))

            })

        put(
            "动画",
            arrayListOf<PageBean>().apply {

                add(PageBean("测试动画", DemoTestAnimationActivity::class.java))
                add(PageBean("帧动画", DemoFrameAnimationActivity::class.java))
                add(PageBean("补间动画", DemoTweenAnimotionActivity::class.java))
                add(PageBean("属性动画", DemoPropertyAnimotionActivity::class.java))

            })

        put(
            "图片",
            arrayListOf<PageBean>().apply {

                add(PageBean("系统-图片", DemoPictureActivity::class.java))

            })

        put(
            "View",
            arrayListOf<PageBean>().apply {

                add(PageBean("Notification", DemoNotificationActivity::class.java))
                add(PageBean("Dialog", DemoDialogActivity::class.java))
                add(PageBean("PopWindow", DemoPopWindowActivity::class.java))
                add(PageBean("TextView", DemoTextViewActivity::class.java))
                add(PageBean("RecycleView", RecycleViewActivity::class.java))
                add(PageBean("ImageView", DemoImageViewActivity::class.java))

            })

        put(
            "View 基础",
            arrayListOf<PageBean>().apply {

                add(PageBean("Bitmap", DemoBitmapActivity::class.java))
                add(PageBean("View 遮盖", DemoViewCoverActivity::class.java))
                add(PageBean("Paint", DemoViewPaintActivity::class.java))
                add(PageBean("Canvas", DemoViewCanvasActivity::class.java))
                add(PageBean("绘制顺序", DemoDrawOrderActivity::class.java))

            })

        put(
            "View 自定义",
            arrayListOf<PageBean>().apply {

                add(PageBean("自定义View", CustomViewActivity::class.java))
                add(PageBean("引导图", GuideViewActivity::class.java))

            })

        put(
            "第三方库",
            arrayListOf<PageBean>().apply {

                add(PageBean("AutoLayout", DemoAutoLayoutActivity::class.java))
                add(PageBean("Glide", DemoGlideActivity::class.java))
                add(PageBean("GifDrawable", DemoGifDrawableActivity::class.java))

            })


        put(
            "功能",
            arrayListOf<PageBean>().apply {

                add(PageBean("倒计时", DemoCountDownActivity::class.java))
                add(PageBean("软键盘", DemoSoftInputActivity::class.java))
                add(PageBean("安装", DemoInstallActivity::class.java))
                add(PageBean("权限", DemoPermissionActivity::class.java))
                add(PageBean("uri", DemoUriActivity::class.java))
                add(PageBean("SchemeUrl", DemoSchemeUrlActivity::class.java))
                add(PageBean("Json", DemoJsonActivity::class.java))
                add(PageBean("Handle", DemoHandleActivity::class.java))

            })


    }

    private fun put(title: String, list: ArrayList<PageBean>) {
        data[PageBean(title, PageListActivity::class.java)] = list
    }


}