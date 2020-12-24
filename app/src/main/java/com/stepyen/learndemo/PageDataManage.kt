package com.stepyen.learndemo

import com.stepyen.demo.androidmanifest.activity.AdjustPanActivity
import com.stepyen.demo.androidmanifest.activity.AdjustResizeActivity
import com.stepyen.demo.androidmanifest.activity.AdjustUnspecifiedActivity
import com.stepyen.demo.androidmanifest.activity.MetaDataActivity
import com.stepyen.demo.androidmanifest.activity.task.TaskActivity
import com.stepyen.demo.animation.activity.DemoFrameAnimationActivity
import com.stepyen.demo.animation.activity.DemoTestAnimationActivity
import com.stepyen.demo.debug.activity.DemoDebugActivity
import com.stepyen.demo.picture.activity.DemoPictureActivity
import com.stepyen.demo.view.dialog.DemoDialogActivity
import com.stepyen.demo.view.popwindow.DemoPopWindowActivity
import com.stepyen.demo.view.recycleview.RecycleViewActivity
import com.stepyen.demo.viewbase.activity.DemoBitmapActivity
import com.stepyen.demo.viewbase.activity.DemoViewCoverActivity
import com.stepyen.demo.viewbase.canvas.DemoViewCanvasActivity
import com.stepyen.demo.viewbase.paint.DemoViewPaintActivity
import com.stepyen.demo.viewcustom.activity.CustomViewActivity
import com.stepyen.demo.viewcustom.activity.GuideViewActivity
import com.stepyen.learndemo.bean.PageBean

/**
 * date：2020-02-12
 * author：stepyen
 * description：页面数据管理
 *
 */
object PageDataManage {
    val data: LinkedHashMap<PageBean, ArrayList<PageBean>> = LinkedHashMap<PageBean, ArrayList<PageBean>>()

    init {


        put("debug", arrayListOf<PageBean>().apply {

            add(PageBean("设备信息", DemoDebugActivity::class.java))


        })

        put("配置清单", arrayListOf<PageBean>().apply {

            add(PageBean("属性：WindowSoftInputMode"))
            add(PageBean("adjustUnspecified", AdjustUnspecifiedActivity::class.java))
            add(PageBean("adjustResize", AdjustResizeActivity::class.java))
            add(PageBean("adjustPan", AdjustPanActivity::class.java))

            add(PageBean("meta-data"))
            add(PageBean("meta-data", MetaDataActivity::class.java))

            add(PageBean("activity 启动模式"))
            add(PageBean("启动模式", TaskActivity::class.java))


        })

        put("组件", arrayListOf<PageBean>().apply {

            add(PageBean("Activity"))
            add(PageBean("别名", TaskActivity::class.java))
            add(PageBean("生命周期", TaskActivity::class.java))
            add(PageBean("屏幕方向", TaskActivity::class.java))


            add(PageBean("ContentProvider"))


            add(PageBean("Intent"))
            add(PageBean("1", TaskActivity::class.java))

        })

        put("动画", arrayListOf<PageBean>().apply {

            add(PageBean("测试动画", DemoTestAnimationActivity::class.java))
            add(PageBean("帧动画", DemoFrameAnimationActivity::class.java))

        })

        put("图片", arrayListOf<PageBean>().apply {

            add(PageBean("系统-图片", DemoPictureActivity::class.java))

        })

        put("View", arrayListOf<PageBean>().apply {

            add(PageBean("Dialog", DemoDialogActivity::class.java))
            add(PageBean("PopWindow", DemoPopWindowActivity::class.java))
            add(PageBean("RecycleView", RecycleViewActivity::class.java))

        })

        put("View 基础", arrayListOf<PageBean>().apply {

            add(PageBean("Bitmap", DemoBitmapActivity::class.java))
            add(PageBean("View 遮盖", DemoViewCoverActivity::class.java))
            add(PageBean("Paint", DemoViewPaintActivity::class.java))
            add(PageBean("Canvas", DemoViewCanvasActivity::class.java))

        })

        put("View 自定义", arrayListOf<PageBean>().apply {

            add(PageBean("自定义View", CustomViewActivity::class.java))
            add(PageBean("引导图", GuideViewActivity::class.java))

        })


    }

    private fun put(title: String, list: ArrayList<PageBean>) {
        data[PageBean(title, PageListActivity::class.java)] = list
    }


}