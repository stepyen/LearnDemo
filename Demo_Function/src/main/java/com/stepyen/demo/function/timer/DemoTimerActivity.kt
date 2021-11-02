package com.stepyen.demo.function.timer

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import java.util.*

/**
 * date：2021/2/21
 * author：stepyen
 * description：
 *
 */
@Route(path = PagePathHub.DemoTimerActivity)
class DemoTimerActivity : BasePageActivity() {

    override var TAG: String = "timer_tag"

    override fun initView() {

        addButton("正确用法", View.OnClickListener {
            usage()
        })

        addButton("timer cancel 出现异常", View.OnClickListener {
            timerCancel()
        })

        addButton("task cancel 出现异常", View.OnClickListener {
            taskCancel()
        })


        addButton("task 添加多次 出现异常", View.OnClickListener {
            taskInSchedule()
        })



    }

    /**
     * 正确用法
     */
    private fun usage() {
        var task :TimerTask?= null

        fun initTask() {
            if (task == null) {
                task = object : TimerTask() {
                    override fun run() {
                        L.d(TAG, "执行task")
                    }
                }
            }
        }

        var timer: Timer = Timer()
        initTask()
        timer.schedule(task,0,1000)
        Thread.sleep(2000)
        task?.cancel()
        task = null
        L.d(TAG, "timer cancel")

        // 创建新的task
        initTask()
        timer.schedule(task,0,1000)
    }


    /**
     * 抛出异常：java.lang.IllegalStateException: Timer already cancelled.
     */
    private fun timerCancel() {
        var task = object : TimerTask() {
            override fun run() {
                L.d(TAG, "执行task")
            }
        }

        var timer: Timer = Timer()
        timer.schedule(task,0,1000)
        timer.cancel()
        L.d(TAG, "timer cancel")
        Thread.sleep(2000)
        timer.schedule(task,0,1000)
    }

    /**
     * 抛出异常：java.lang.IllegalStateException: Task already scheduled or cancelled
     */
    private fun taskCancel() {
        var task = object : TimerTask() {
            override fun run() {
                L.d(TAG, "执行task")
            }
        }

        var timer: Timer = Timer()
        timer.schedule(task,0,1000)
        task.cancel()
        L.d(TAG, "task cancel")
        Thread.sleep(2000)
        timer.schedule(task,0,1000)
    }


    /**
     * 同一个task添加多次进 timer
     * 抛出异常：java.lang.IllegalStateException: Task already scheduled or cancelled
     */
    private fun taskInSchedule() {
        var task = object : TimerTask() {
            override fun run() {
                L.d(TAG, "执行task")
            }
        }

        var timer: Timer = Timer()
        timer.schedule(task,0,1000)
        timer.schedule(task,0,1000)

    }
}