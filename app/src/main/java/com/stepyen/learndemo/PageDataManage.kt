package com.stepyen.learndemo

import com.stepyen.demo.animation.activity.DemoFrameAnimationActivity
import com.stepyen.demo.animation.activity.DemoTestAnimationActivity
import com.stepyen.demo.debug.activity.DemoDebugActivity
import com.stepyen.demo.picture.activity.DemoSystemPictureActivity
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

//            add(PageBean("设备信息", DeviceActivity::class.java))
            add(PageBean("设备信息", DemoDebugActivity::class.java))


        })
//
//        put("测试", arrayListOf<PageBean>().apply {
//
//            add(PageBean("kotlin", KotlinActivity::class.java))
//            add(PageBean("Java测试", JavaActivtity::class.java))
//            add(PageBean("Copy", CopyActivity::class.java))
//
//        })
//
//
//        put("Java", arrayListOf<PageBean>().apply {
//
//
//            add(PageBean("补间动画", ActivityActivity::class.java))
//            add(PageBean("属性动画", ActivityActivity::class.java))
//            add(PageBean("文件", FileActivity::class.java))
//
//        })
//
//
//        put("kotlin", arrayListOf<PageBean>().apply {
//
//
//
//        })
//
//
//        put("App", arrayListOf<PageBean>().apply {
//
//            add(PageBean("配置清单", ManifestActivity::class.java))
//            add(PageBean("手机参数", PhoneParamActivity::class.java))
//            add(PageBean("WindowSoftInputMode", WindowSoftInputModeActivity::class.java))
//
//
//        })
//
//        put("View", arrayListOf<PageBean>().apply {
//            add(PageBean("ConstraintLayout", ConstraintLayoutActivity::class.java))
//            add(PageBean("TextView", TextViewActivity::class.java))
//            add(PageBean("ImageView", ImageViewActivity::class.java))
//            add(PageBean("Notification", NotificationActivity::class.java))
//            add(PageBean("SurfaceView", SurfaceViewActivity::class.java))
//            add(PageBean("两个 SurfaceView 层级顺序研究", TwoSurfaceViewOrderActivity::class.java))
//            add(PageBean("Android 和 h5 交互", WebViewH5Activity::class.java))
//
//
//        })
//        put("View 基础", arrayListOf<PageBean>().apply {
//
//            add(PageBean("Notification", NotificationActivity::class.java))
//            add(PageBean("View 重叠", ViewOverlayActivity::class.java))
//
//
//        })
//        put("View 自定义", arrayListOf<PageBean>().apply {
//
//            add(PageBean("自定义View", ViewCustomActivity::class.java))
//
//
//        })
//
//        put("组件", arrayListOf<PageBean>().apply {
//
//            add(PageBean("Activity", ActivityActivity::class.java))
//            add(PageBean("Service", ServiceActivity::class.java))
//            add(PageBean("ContentProvide", ContentProviderActivity::class.java))
//            add(PageBean("BroadcastReceiver", ActivityActivity::class.java))
//            add(PageBean("Intent", IntentActivity::class.java))
//            add(PageBean("Fragment", TestFragmentActivity::class.java))
//            add(PageBean("Task", TaskActivity::class.java))
//
//        })
        put("动画", arrayListOf<PageBean>().apply {

            add(PageBean("测试动画", DemoTestAnimationActivity::class.java))
            add(PageBean("帧动画", DemoFrameAnimationActivity::class.java))
//            add(PageBean("补间动画", ActivityActivity::class.java))
//            add(PageBean("属性动画", ActivityActivity::class.java))

        })

        put("图片", arrayListOf<PageBean>().apply {

            add(PageBean("系统-图片", DemoSystemPictureActivity::class.java))

        })


//
//        put("网络", arrayListOf<PageBean>().apply {
//
//            add(PageBean("socket", SocketActivity::class.java))
//            add(PageBean("websocket", WebSocketActivity::class.java))
//            add(PageBean("OkHttp", OkhttpActivity::class.java))
//            add(PageBean("Retrofit", RetrofitActivity::class.java))
//
//        })
//        put("音视频", arrayListOf<PageBean>().apply {
//
//            add(PageBean("音频", AudioActivity::class.java))
//
//        })
//
//        put("第三方", arrayListOf<PageBean>().apply {
//
//            add(PageBean("友盟", UMengActivity::class.java))
//            add(PageBean("驰声", ChivoxActivity::class.java))
//            add(PageBean("msa", MsaActivity::class.java))
//            add(PageBean("Gson", GsonActivity::class.java))
//            add(PageBean("个推", GetuiActivity::class.java))
//            add(PageBean("Glide", GlideActivity::class.java))
//            add(PageBean("日志", LogActivity::class.java))
//
//        })
//
//        put("功能", arrayListOf<PageBean>().apply {
//
//            add(PageBean("Handle", HandleActivity::class.java))
//            add(PageBean("Json", JsonActivity::class.java))
//            add(PageBean("Uri", UriActivity::class.java))
//            add(PageBean("加解密", EncryptActivity::class.java))
//            add(PageBean("异常", ExceptionActivity::class.java))
//            add(PageBean("ShemeUrl", SchemeUrlActivity::class.java))
//            add(PageBean("Assets", AssetsActivity::class.java))
//            add(PageBean("Bitmap", BitmapActivity::class.java))
//            add(PageBean("倒计时", CountDownActivity::class.java))
//            add(PageBean("避免 startForResult", AvoidResultActivity::class.java))
//            add(PageBean("权限", PermissionActivity::class.java))
//
//        })
//
//
//
//        put("其他", arrayListOf<PageBean>().apply {
//
//            add(PageBean("学习 debug", LearnDebugActivity::class.java))
//
//
//        })
//        put("屏幕适配", arrayListOf<PageBean>().apply {
//
//            add(PageBean("折叠屏", FoldScreenActivity::class.java))
//
//
//        })
//
//        put("存储", arrayListOf<PageBean>().apply {
//
//            add(PageBean("存储", StorageActivity::class.java))
//
//        })
//

    }

    private fun put(title: String, list: ArrayList<PageBean>) {
        data[PageBean(title, PageListActivity::class.java)] = list
    }


}