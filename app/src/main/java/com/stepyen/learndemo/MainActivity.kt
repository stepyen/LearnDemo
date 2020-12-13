package com.stepyen.learndemo

import android.content.Intent
import android.view.View
import com.stepyen.demo.base.base.BasePageActivity
class MainActivity : BasePageActivity() {
    override var TAG =  "MainActivityTAG"

    override fun initView() {
        for (data in PageDataManage.data) {
            val pageBean = data.key
            val pageBeanList = data.value
            addButton(pageBean.title, View.OnClickListener {

                // 只有一个选项时，直接跳转过去
                if (pageBeanList.size ==1) {
                    startActivity(Intent(this@MainActivity, pageBeanList[0].cls))
                }else{
                    startActivity(Intent(this@MainActivity, PageListActivity::class.java).apply {
                        putExtra(PageListActivity.KEY_PAGE_LIST , pageBeanList)
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