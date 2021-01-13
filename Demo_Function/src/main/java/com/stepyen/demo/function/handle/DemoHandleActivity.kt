package com.stepyen.demo.function.handle

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.view.View
import com.stepyen.demo.base.base.BasePageActivity

/**
 * date：2021/1/9
 * author：stepyen
 * description：
 *
 */
class DemoHandleActivity : BasePageActivity() {

    override fun initView() {

        mainSendMsgToWordThread()
        wordThreadSendMsgToMain()
        sendMsgThreadEachOther()

    }


    /**
     * 主线程给子线程发送消息
     */
    private fun mainSendMsgToWordThread() {

        var handler: Handler? = null

        addButton("主线程给子线程发消息", View.OnClickListener {
            handler?.sendEmptyMessage(123)
        })


        Thread(Runnable {
            Looper.prepare()
            handler = object : Handler() {
                override fun handleMessage(msg: Message?) {
                    msg?.let {
                        when (it.what) {
                            123 -> {
                                runOnUiThread {
                                    toast("子线程收到主线程的消息")
                                }
                            }
                        }
                    }


                }
            }
            Looper.loop()
        }).start()
    }


    /**
     * 子线程给主线程发送消息
     */
    private fun wordThreadSendMsgToMain() {

        var handler = object : Handler() {
            override fun handleMessage(msg: Message?) {
                msg?.let {
                    when (it.what) {
                        123 -> {
                            runOnUiThread {
                                toast("主线程收到子线程的消息")
                            }
                        }
                    }
                }
            }
        }

        addButton("子线程给主线程发送消息", View.OnClickListener {

            Thread(Runnable {
                handler.sendEmptyMessage(123)
            }).start()

        })
    }

    /**
     * 主进程和子进程互发消息
     */
    private fun sendMsgThreadEachOther() {

        addTextView("主进程和子进程互发消息")


        // 主线程下
        val mainHandler: Handler = object : Handler() {
            override fun handleMessage(msg: Message?) {
                msg?.let {
                    when (it.what) {
                        345 -> {
                            toast("主线程收到子线程回敬的消息")

                        }
                    }
                }
            }
        }

        var handlerThread: HandlerThread = HandlerThread("HandlerThread")
        handlerThread.start()
        // 子线程下
        val handler: Handler = object : Handler(handlerThread.looper) {
            override fun handleMessage(msg: Message?) {
                msg?.let {
                    when (it.what) {
                        123 -> {
                            runOnUiThread {
                                toast("子线程收到主线程的消息")
                                mainHandler.sendEmptyMessage(345)
                            }
                        }
                    }
                }
            }

        }


        addButton("主线程给子线程发送消息", View.OnClickListener {

            handler.sendEmptyMessage(123)

        })
    }
}
