package com.stepyen.demo.thirdlab.glide

import com.alibaba.android.arouter.facade.annotation.Route
import com.bumptech.glide.Glide
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import kotlinx.android.synthetic.main.demo_activity_glide_load_destory.*

/**
 * date：2021/2/2
 * author：stepyen
 * description：
 *
 *
 *
 */
@Route(path = PagePathHub.DemoGlideLoadDestoryActivity)
class DemoGlideLoadDestoryActivity : BasePageActivity(){

    override var TAG: String = "DemoGlideLoadDestoryActivity_TAG"

    override fun initView() {
        addView(R.layout.demo_activity_glide_load_destory)

        //        val url = "http://pic.beta.baby-bus.com/storage/image/1/d5b6c748/160982592353278892.png"
        val url = "https://cdn.tuisnake.com/mami-media/img/q4qt7y5edk.gif?type=202&sckId=716&rid=0adca1f6kzi26jyl-11430299&deviceId=7258a1fc-1fb1-449a-82c1-37ee40d2916b&slotId=410537&appId=87880&sckFromType=0&os=unknown&city=%E7%A6%8F%E5%B7%9E%E5%B8%82&region=%E7%A6%8F%E5%BB%BA&timestamp=1644886915876"
        Glide
            .with(this)
            .load(url)
            .into(testIv)
    }


    override fun finish() {
//        L.d(TAG,"finish")
//        UIUtil.postTaskDelay(Runnable {
//            if (ActivityUtil.isDestroy(this)) {
//                L.d(TAG,"Activity 已经销毁")
//                return@Runnable
//            }
//
//            L.d(TAG,"加载图片")
//            val url = "http://pic.beta.baby-bus.com/storage/image/1/d5b6c748/160982592353278892.png"
//            Glide
//                .with(this)
//                .load(url)
//                .into(testIv)
//
//        },1000)

        super.finish()

    }

    override fun onDestroy() {
        super.onDestroy()

        L.d(TAG,"onDestroy")
//        Glide.clear(testIv)
    }

}