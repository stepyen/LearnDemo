package com.stepyen.demo.thirdlab.gson

import com.alibaba.android.arouter.facade.annotation.Route
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.stepyen.demo.base.PagePathHub
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L
import com.stepyen.demo.thirdlab.gson.bean.Book
import com.stepyen.demo.thirdlab.gson.core.TestExclude
import kotlinx.android.synthetic.main.activity_demo_gson.*


/**
 * date：2021/2/2
 * author：stepyen
 * description：
 *
 *
 */
@Route(path = PagePathHub.DemoGsonActivity)
class DemoGsonActivity : BasePageActivity() {

    override var TAG: String = "DemoGsonActivity_TAG"

    override fun initView() {
        addView(R.layout.activity_demo_gson)


//        parceArray()
//
//        resolveException()

        addButton("测试排除字段"){
            TestExclude().test()
        }
    }


    /**
     * 解决异常问题
     *
     *
     * 可修改
     */
    private fun resolveException() {

        resolveExceptionBtn.setOnClickListener {
            L.d(TAG,"开始解析")
            val json  =  """
                ""
            """.trimIndent()

            try {
                val tempList: List<Book> =
                    Gson().fromJson(
                        json,
                        object :
                            TypeToken<List<Book?>?>() {}.type
                    )

                L.d(TAG,"解析完成")
            } catch (e: JsonSyntaxException) {
                e.printStackTrace()
                L.d(TAG,"出现异常")
            }

        }
    }

    /**
     * 解析数组
     */
    private fun parceArray() {


        fun fromJson(json: String?) {
            val tempList: List<Book> =
                Gson().fromJson(
                    json,
                    object :
                        TypeToken<List<Book?>?>() {}.type
                )
        }

        /**
         * 触发 com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was STRING at line 1 column 2 path $
         */
        parceArrayBtn1.setOnClickListener {
            val json  =  """
                ""
            """.trimIndent()

            fromJson(json)
        }

        /**
         * 触发 java.lang.IllegalStateException: Gson().fromJson(
                 …{}.type
                ) must not be null
         */
        parceArrayBtn11.setOnClickListener {
            val json  = ""
            fromJson(json)
        }

        /**
         * 触发 java.lang.IllegalStateException: Gson().fromJson(
                …{}.type
                ) must not be null
         */
        parceArrayBtn10.setOnClickListener {

            fromJson(null)
        }

        /**
         * com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was STRING at line 1 column 2 path $
         */
        parceArrayBtn12.setOnClickListener {
            val json  =  """
                "123"
            """.trimIndent()

            fromJson(json)
        }

        /**
         * com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was NUMBER at line 1 column 4 path $
         */
        parceArrayBtn2.setOnClickListener {
            val json  =  """
                123
            """.trimIndent()

            fromJson(json)
        }

        /**
         * 没有异常
         */
        parceArrayBtn3.setOnClickListener {
            val json  =  """
                []
            """.trimIndent()

            fromJson(json)
        }

        /**
         * 触发 com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected BEGIN_OBJECT but was NUMBER at line 1 column 5 path $[0]
         */
        parceArrayBtn31.setOnClickListener {
            val json  =  """
                [123]
            """.trimIndent()

            fromJson(json)
        }

        /**
         * 触发 com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $
         */
        parceArrayBtn4.setOnClickListener {
            val json  =  """
                {}
            """.trimIndent()

            fromJson(json)
        }
    }



}