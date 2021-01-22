package com.stepyen.demo.base

import com.stepyen.demo.base.bean.PageBean

/**
 * date：2021/1/22
 * author：stepyen
 * description：
 *
 */
object PageManager {

    val data: LinkedHashMap<PageBean, ArrayList<PageBean>> = LinkedHashMap<PageBean, ArrayList<PageBean>>()

    private fun put(title: String, list: ArrayList<PageBean>) {
        data[PageBean(title, PagePathHub.PageListActivity)] = list
    }

    init {
        put(
            "debug",
            arrayListOf<PageBean>().apply {

                add(PageBean("设备信息", PagePathHub.DemoDebugActivity))

            })

        put(
            "App",
            arrayListOf<PageBean>().apply {

                add(PageBean("资源", PagePathHub.DemoResourceActivity))
                add(PageBean("drawable", PagePathHub.DemoDrawableActivity))

            })

        put(
            "配置清单",
            arrayListOf<PageBean>().apply {

                add(PageBean("configChanges", PagePathHub.DemoConfigChangesActivity))
                add(PageBean("launchMode", PagePathHub.DemoLaunchModeActivity))
                add(PageBean("windowSoftInputMode", PagePathHub.DemoWindowSoftInputModeActivity))
                add(PageBean("screenOrientation", PagePathHub.DemoScreenOrientationActivity))
                add(PageBean("meta-data", PagePathHub.DemoMetaDataActivity))
                add(PageBean("max_aspect", PagePathHub.DemoMaxAspectActivity))

            })

        put(
            "组件",
            arrayListOf<PageBean>().apply {

                add(PageBean("Activity"))
                add(PageBean("别名", PagePathHub.DemoLaunchModeActivity))
                add(PageBean("生命周期", PagePathHub.DemoLaunchModeActivity))
                add(PageBean("屏幕方向", PagePathHub.DemoLaunchModeActivity))


                add(PageBean("ContentProvider"))


                add(PageBean("Intent"))
                add(PageBean("1", PagePathHub.DemoLaunchModeActivity))

            })

        put(
            "动画",
            arrayListOf<PageBean>().apply {

                add(PageBean("测试动画", PagePathHub.DemoTestAnimationActivity))
                add(PageBean("帧动画", PagePathHub.DemoFrameAnimationActivity))
                add(PageBean("补间动画", PagePathHub.DemoTweenAnimotionActivity))
                add(PageBean("属性动画", PagePathHub.DemoPropertyAnimotionActivity))

            })

        put(
            "图片",
            arrayListOf<PageBean>().apply {

                add(PageBean("系统-图片", PagePathHub.DemoPictureActivity))

            })

        put(
            "View",
            arrayListOf<PageBean>().apply {

                add(PageBean("Notification", PagePathHub.DemoNotificationActivity))
                add(PageBean("Dialog", PagePathHub.DemoDialogActivity))
                add(PageBean("PopWindow", PagePathHub.DemoPopWindowActivity))
                add(PageBean("TextView", PagePathHub.DemoTextViewActivity))
                add(PageBean("RecycleView", PagePathHub.RecycleViewActivity))
                add(PageBean("ImageView", PagePathHub.DemoImageViewActivity))

            })

        put(
            "View 基础",
            arrayListOf<PageBean>().apply {

                add(PageBean("生命周期", PagePathHub.DemoViewLifecycleActivity))
                add(PageBean("Paint", PagePathHub.DemoViewPaintActivity))
                add(PageBean("测量", PagePathHub.DemoViewMeasureActivity))
                add(PageBean("Canvas", PagePathHub.DemoViewCanvasActivity))
                add(PageBean("绘制顺序", PagePathHub.DemoDrawOrderActivity))
                add(PageBean("Bitmap", PagePathHub.DemoBitmapActivity))
                add(PageBean("View 遮盖", PagePathHub.DemoViewCoverActivity))
                add(PageBean("手势", PagePathHub.DemoViewGestureActivity))
                add(PageBean("滚动", PagePathHub.DemoViewScrollActivity))
            })

        put(
            "View 自定义",
            arrayListOf<PageBean>().apply {

                add(PageBean("自定义View", PagePathHub.CustomViewActivity))
                add(PageBean("引导图", PagePathHub.GuideViewActivity))

            })

        put(
            "第三方库",
            arrayListOf<PageBean>().apply {

                add(PageBean("AutoLayout", PagePathHub.DemoAutoLayoutActivity))
                add(PageBean("Glide", PagePathHub.DemoGlideActivity))
                add(PageBean("GifDrawable", PagePathHub.DemoGifDrawableActivity))
                add(PageBean("msa", PagePathHub.DemoMsaActivity))

            })


        put(
            "功能",
            arrayListOf<PageBean>().apply {

                add(PageBean("倒计时", PagePathHub.DemoCountDownActivity))
                add(PageBean("软键盘", PagePathHub.DemoSoftInputActivity))
                add(PageBean("安装", PagePathHub.DemoInstallActivity))
                add(PageBean("权限", PagePathHub.DemoPermissionActivity))
                add(PageBean("uri", PagePathHub.DemoUriActivity))
                add(PageBean("SchemeUrl", PagePathHub.DemoSchemeUrlActivity))
                add(PageBean("Json", PagePathHub.DemoJsonActivity))
                add(PageBean("Handle", PagePathHub.DemoHandleActivity))

            })

    }

}