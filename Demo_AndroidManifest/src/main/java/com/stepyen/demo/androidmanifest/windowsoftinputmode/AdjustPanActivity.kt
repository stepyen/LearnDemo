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
 * pan：平移
 *
 */
@Route(path = PagePathHub.AdjustPanActivity)
class AdjustPanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adjust_pan)
    }
}