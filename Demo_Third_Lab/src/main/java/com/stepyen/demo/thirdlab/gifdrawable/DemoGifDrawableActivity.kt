package com.stepyen.demo.thirdlab.gifdrawable

import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.thirdlab.R
import kotlinx.android.synthetic.main.activity_demo_gif_drawable.*
import pl.droidsonroids.gif.GifDrawable
import java.io.File


/**
 * date：2021/1/6
 * author：stepyen
 * description：学习 Glide
 *
 */
@Route(path = PagePathHub.DemoGifDrawableActivity)
class DemoGifDrawableActivity : BasePageActivity(){

    override fun initView() {
        addView(R.layout.activity_demo_gif_drawable)


        loadGifFromSD()

    }

    /**
     * 从sd卡中加载gif
     */
    private fun loadGifFromSD() {
        val file = File("/storage/emulated/0/Pictures/boy.gif")
        val gifDrawable = GifDrawable(file)
        gifImageViewFormSd.setImageDrawable(gifDrawable)
    }




}