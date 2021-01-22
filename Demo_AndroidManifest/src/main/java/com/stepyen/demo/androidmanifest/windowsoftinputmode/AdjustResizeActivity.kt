package com.stepyen.demo.androidmanifest.windowsoftinputmode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.androidmanifest.R
import com.stepyen.demo.base.PagePathHub

/**
 * date：2020-03-29
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.AdjustResizeActivity)
class AdjustResizeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adjust_resize)
    }
}