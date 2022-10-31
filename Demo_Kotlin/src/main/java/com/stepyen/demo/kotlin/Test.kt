package com.stepyen.demo.kotlin

import java.text.DecimalFormat
import java.util.concurrent.TimeUnit


/**
 * date：2021/1/28
 * author：stepyen
 * description：
 */
object Test {

    val glass:Glass?=null

    @JvmStatic
    fun main(args: Array<String>) {







    }


    class Glass {
        var name:String?=""

    }


    /**
     * test
     *
    println("1 ${changeDuration(1)}")
    println("61 ${changeDuration(61)}")
    println("3601 ${changeDuration(3601)}")
    println("3600 ${changeDuration(3600)}")
    println("-1 ${changeDuration(-1)}")
    println("3599 ${changeDuration(3599)}")
    println("86399 ${changeDuration(86399)}")
     *
     */
    private fun changeDuration(duration: Int?): String {

        if (duration == null || duration <= 0) {
            return "00:00"
        }

        val df = DecimalFormat("00")
        val oneHourToSeconds = TimeUnit.HOURS.toSeconds(1)
        val oneMinutesToSeconds = TimeUnit.MINUTES.toSeconds(1)

        val sb = StringBuilder()



        // 时
        val hour = duration / oneHourToSeconds
        if (hour>0) {
            sb.append("${df.format(hour)}")
            sb.append(":")
        }

        // 分
        var minutes = duration / oneMinutesToSeconds %  oneMinutesToSeconds
        if (minutes<0) {
            minutes = 0
        }
        sb.append("${df.format(minutes)}")
        sb.append(":")

        // 秒
        var seconds = duration %  oneMinutesToSeconds
        if (seconds<0) {
            seconds = 0
        }
        sb.append("${df.format(seconds)}")

        return sb.toString()
    }
}