package com.stepyen.demo.kotlin

/**
 * date：2020/12/24
 * author：stepyen
 * description：
 *
 */
class TestFloat {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            test()
        }


        fun test() {
            val a :Float = 0.6f
            val b = a + 0.1f
            print(b.toFloat())        // 0.70000005
        }
    }




}