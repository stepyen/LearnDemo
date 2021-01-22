package com.stepyen.demo.base

import android.content.Intent
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.stepyen.demo.base.base.BasePageActivity


class MainActivity : BasePageActivity() {
    override var TAG =  "MainActivity_TAG"

    override fun initView() {


        for (data in PageManager.data) {
            val pageBean = data.key
            val pageBeanList = data.value
            addButton(pageBean.title, View.OnClickListener {

                // 只有一个选项时，直接跳转过去
                if (pageBeanList.size ==1) {
                    ARouter.getInstance().build(pageBeanList[0].path).navigation()
                }else{
                    startActivity(Intent(this@MainActivity, PageListActivity::class.java).apply {
                        putExtra(PageListActivity.KEY_PAGE_LIST, pageBeanList)
                    })
                }
            })
        }

        initDataSource()
    }


    private fun initDataSource() {
//        DataResouceManager.copyALL()
    }

}