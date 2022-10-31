package com.stepyen.learndemo

import android.content.Intent
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.stepyen.demo.base.PageListActivity
import com.stepyen.demo.base.PageManager
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.thirdlab.glide.DemoGlideLoadDestoryActivity


/**
 *
 *
 *
 */
class MainActivity : BasePageActivity() {
    override var TAG =  "MainActivity_TAG"

    override fun initView() {

        addButton("glide测试", View.OnClickListener {

            startActivity(Intent(this@MainActivity, DemoGlideLoadDestoryActivity::class.java).apply {

            })
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


    override fun onStart() {
        super.onStart()
        Log.d("haha","MainActivity#onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("haha","MainActivity#onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("haha","MainActivity#onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("haha","MainActivity#onStop")
    }

}