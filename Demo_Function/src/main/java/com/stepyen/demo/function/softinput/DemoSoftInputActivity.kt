package com.stepyen.demo.function.softinput
import android.app.Activity
import android.graphics.Rect
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.function.R

/**
 * date：2020-04-02
 * author：stepyen
 * description：软键盘问题
 *
 *
 *
 */
@Route(path = PagePathHub.DemoSoftInputActivity)
class DemoSoftInputActivity : BasePageActivity() {
    override var TAG: String = "DemoSoftInputActivity_TAG"

    override fun initView() {
        addView(R.layout.demo_activity_soft_input)
        softInputHeightListen()

    }


    /**
     * 监听软键盘高度
     */
    private fun softInputHeightListen() {
        val contentView = this.findViewById(android.R.id.content) as FrameLayout
        contentView.viewTreeObserver
            .addOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener {
                L.d(TAG,"软件盘高度：${getContentViewInvisibleHeight(this@DemoSoftInputActivity)}")
            })

    }


    /*
    获取内容视图的可见高度
     */
    private fun getContentViewInvisibleHeight(activity: Activity): Int {
        val contentView = activity.findViewById<FrameLayout>(android.R.id.content)
        val contentViewChild = contentView.getChildAt(0)
        val outRect = Rect()
        contentViewChild.getWindowVisibleDisplayFrame(outRect)

        L.d(TAG,"内容view-bottom：${contentViewChild.bottom}")
        L.d(TAG,"屏幕可见：${outRect.toString()}")

        return contentViewChild.bottom - outRect.bottom
    }


}