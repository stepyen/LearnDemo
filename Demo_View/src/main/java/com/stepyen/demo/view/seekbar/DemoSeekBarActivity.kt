package com.stepyen.demo.view.seekbar

import android.widget.SeekBar
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R
import kotlinx.android.synthetic.main.activity_demo_seekbar.*
import kotlinx.android.synthetic.main.activity_demo_spinner.*

/**
 * date：2021/10/22
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoSeekBarActivity)
class DemoSeekBarActivity : BasePageActivity() {

    override var TAG = "DemoSeekBarActivity_TAG"


    override fun initView() {
        addView(R.layout.activity_demo_seekbar)

        simpleSeekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{

            /**
             * 在进度条变更时触发
             *
             * @param fromUser true表示用户拖动，false表示代码设置进度
             */
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            /**
             * 开始拖动进度条时触发
             */
            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            /**
             * 停止拖动进度条时触发
             */
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        simpleSeekBar.progress = 10

    }
}