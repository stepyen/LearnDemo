package com.stepyen.demo.view.spinner

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.view.R
import com.stepyen.xutil.tip.ToastUtils
import kotlinx.android.synthetic.main.activity_demo_spinner.*


/**
 * date：8/31/21
 * author：stepyen
 * description：Spinner 下拉列表控件
 *
 */
@Route(path = PagePathHub.DemoSpinnerActivity)
class DemoSpinnerActivity : BasePageActivity(){

    override fun initView() {
        addView(R.layout.activity_demo_spinner)

        xmlBindData()
        codeBindData()
        customStyle()
        common(spinnerModeDropdownSpinner)
        common(spinnerModeDialogSpinner)

    }

    /**
     * xml 绑定数据
     */
    private fun xmlBindData() {
        xmlBindDataSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val languages = resources.getStringArray(R.array.languages)
                ToastUtils.toast("点击的是${languages[position]}")
            }

        }


    }


    /**
     * 代码中绑定数据
     */
    private fun codeBindData() {
        val mItems = resources.getStringArray(R.array.languages)

        val defaultLyaout = android.R.layout.simple_spinner_item     // 未展开时的样式
        val dropdownLyaout = android.R.layout.simple_spinner_dropdown_item     // 展开时的样式
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, defaultLyaout, mItems)
        adapter.setDropDownViewResource(dropdownLyaout)

        codeBindDataSpinner.adapter = adapter
        codeBindDataSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val languages = resources.getStringArray(R.array.languages)
                ToastUtils.toast("点击的是${languages[position]}")
            }

        }

    }

    /**
     * 自定义  Spinner 样式,「未完成」
     */
    private fun customStyle() {

        val mItems = resources.getStringArray(R.array.languages)

        val defaultLyaout = android.R.layout.simple_spinner_item     // 未展开时的样式
        val dropdownLyaout = android.R.layout.simple_spinner_dropdown_item     // 展开时的样式
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, defaultLyaout, mItems)
        adapter.setDropDownViewResource(dropdownLyaout)

        customStyleSpinner.adapter = adapter
        customStyleSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val languages = resources.getStringArray(R.array.languages)
                ToastUtils.toast("点击的是${languages[position]}")
            }

        }
    }

    /**
     * 通用配置
     */
    private fun common(spinner: Spinner?) {
        spinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val languages = resources.getStringArray(R.array.languages)
                ToastUtils.toast("点击的是${languages[position]}")
            }

        }

    }
}