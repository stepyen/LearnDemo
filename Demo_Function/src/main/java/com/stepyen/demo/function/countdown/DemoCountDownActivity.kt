package com.stepyen.demo.function.countdown
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L

/**
 * date：2020-04-02
 * author：stepyen
 * description：计时
 *
 */
@Route(path = PagePathHub.DemoCountDownActivity)
class DemoCountDownActivity : BasePageActivity() {
    override var TAG: String = "CountDownTAG"

    private var mCountTimeHelp:CountTimeHelp?= null

    override fun initView() {

        addButton("开始倒计时", View.OnClickListener {
            L.d(TAG,"计时开始")
            mCountTimeHelp = CountTimeHelp.newCountDownHelp(3)
            mCountTimeHelp?.setOnCountListener(object :CountTimeHelp.OnCountListener{
                override fun onFinish() {
                    L.d(TAG, "onFinish: ")
                }

                override fun onCount(time: Int, hour: Int, minute: Int, second: Int) {
                    L.d(TAG, "onCount: $time:$hour:$minute:$second")
                }

            })
            mCountTimeHelp?.start()
        })

        addButton("开始计时", View.OnClickListener {
            mCountTimeHelp = CountTimeHelp.newCountUpHelp(3)
            mCountTimeHelp?.setOnCountListener(object :CountTimeHelp.OnCountListener{
                override fun onFinish() {
                    L.d(TAG, "onFinish: ")
                }

                override fun onCount(time: Int, hour: Int, minute: Int, second: Int) {
                    L.d(TAG, "onCount: $time:$hour:$minute:$second")
                }

            })
            mCountTimeHelp?.start()
        })

        addButton("继续计时", View.OnClickListener {
            mCountTimeHelp?.start()
            L.d(TAG,"start")
        })

        addButton("停止", View.OnClickListener {
            mCountTimeHelp?.stop()
            L.d(TAG,"stop")
        })

        addButton("重置", View.OnClickListener {
            mCountTimeHelp?.reset()
            L.d(TAG,"reset")
        })
    }


}