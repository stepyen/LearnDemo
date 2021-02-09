package com.stepyen.demo.thirdlab.glide

import com.alibaba.android.arouter.facade.annotation.Route
import com.bumptech.glide.Glide
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import kotlinx.android.synthetic.main.activity_demo_glide.*

/**
 * date：2021/2/2
 * author：stepyen
 * description：
 *
 *
 * 问题：
 * 1、glide不能加载后缀是 jepg 的图片，没有设置size，所以不能加载？
 *
 */
@Route(path = PagePathHub.DemoGlideActivity)
class DemoGlideActivity : BasePageActivity(){

    override fun initView() {
        addView(R.layout.activity_demo_glide)

        png()
        gif()
        hardGif()

    }

    /**
     * 加载 png
     */
    private fun png() {
        val url = "http://pic.beta.baby-bus.com/storage/image/1/d5b6c748/160982592353278892.png"
        Glide
            .with(this)
            .load(url)
            .into(pngIv)
    }

    /**
     * 加载gif
     */
    private fun gif() {
        // 蝙蝠侠
//            val url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.mp.itc.cn%2Fq_mini%2Cc_zoom%2Cw_640%2Fupload%2F20170805%2Fe9d63ceab58743e49426a834f56ad209.jpg&refer=http%3A%2F%2Fimg.mp.itc.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612508271&t=f8e31174b311a84c19d10ee5f05f156c"
//            val url = "http://pic.beta.baby-bus.com/storage/image/1/d5b6c748/160989631731334031.gif"
//        val url = "/storage/emulated/0/Pictures/boy.gif"
        val url = R.drawable.boy

        Glide
            .with(this)
            .load(url)
            .asGif()
            .into(gifIv)
    }

    /**
     * ImageView 设置硬件加速，加载gif
     *
     */
    private fun hardGif() {
//        val url = "/storage/emulated/0/Pictures/boy.gif"
        val url = R.drawable.boy
        Glide
            .with(this)
            .load(url)
            .asGif()
            .into(hardImageView)

    }




}