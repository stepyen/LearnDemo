package com.stepyen.learndemo

import android.content.Intent
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.stepyen.demo.base.PageListActivity
import com.stepyen.demo.base.PageManager
import com.stepyen.demo.base.base.BasePageActivity


class MainActivity : BasePageActivity() {
    override var TAG =  "MainActivity_TAG"

    override fun initView() {
        addButton("msa", View.OnClickListener {
            com.stepyen.demo.msa13impl.Test().init(this@MainActivity)
//            com.stepyen.demo.msa23impl.Test().init(this@MainActivity)
        })

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