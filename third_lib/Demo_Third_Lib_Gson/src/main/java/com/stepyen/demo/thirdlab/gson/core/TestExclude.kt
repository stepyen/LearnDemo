package com.stepyen.demo.thirdlab.gson.core

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import com.stepyen.demo.base.utils.L
import java.lang.reflect.Modifier

/**
 * date：6/2/21
 * author：stepyen
 * description：排除不需要 json 序列化的字段
 *
 */
class TestExclude {

    companion object {
        const val TAG = "test_exclude_tag"
    }

    fun test() {
        Normal().test()
        ExcludeNull().test()
        ExcludeTransient().test()
        ExcludeFieldsWithModifiers().test()
        ExcludeFieldsWithoutExposeAnnotation().test()
        SetExclusionStrategies().test()
    }

    /**
     * gson 的正常情况
     */
    class Normal {
        var name: String? = null            // 字段为null时，不会被json序列化
        var age: Int = 17
        var sex: String = ""

        companion object{
            var height:Int = 172
        }

        fun test() {

            val json = Gson().toJson(this)
            L.d(TAG, "正常序列化：$json")             // {"age":17,"sex":""}
        }
    }


    /**
     * json序列化为null的字段
     */
    class ExcludeNull {
        var name: String? = null
        var age: Int = 17

        fun test() {
            val gsonBuilder = GsonBuilder()
                .serializeNulls()                   // 将为null的字段也json序列化
                .create()

            val json = gsonBuilder.toJson(this)

            L.d(TAG, "json序列化为null的字段：$json")
        }
    }


    /**
     * 排除字段-添加了「Transient」
     */
    class ExcludeTransient {
        @Transient
        var name: String = "小明"     // 会被排除

        var age: Int = 17

        fun test() {
            val json = Gson().toJson(this)
            L.d(TAG, "排除字段-添加了「Transient」：$json")       // {"age":17}
        }
    }


    /**
     * 排除字段-指定修饰符
     */
    class ExcludeFieldsWithModifiers {
        val name: String = "小明"
        var age: Int = 17

        fun test() {
            val gsonBuilder = GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL)    // Modifier.PROTECTED 测试无效
                .create()

            val json = gsonBuilder.toJson(this)
            L.d(TAG, "排除字段-指定修饰符：$json")

        }
    }


    /**
     * 只json序列化添加了「@Expose」标注的字段
     */
    class ExcludeFieldsWithoutExposeAnnotation {
        @Expose
        var name: String = "小明"
        var age: Int = 17           // 会被排除

        fun test() {

            val gsonBuilder = GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()

            val json = gsonBuilder.toJson(this)

            L.d(TAG, "只json序列化添加了「@Expose」标注的字段：${json}")    // {"name":"小明"}
        }
    }


    /**
     * 排除字段-定制策略
     */
    class SetExclusionStrategies {
        var name: String = "小明"
        var _age: Int = 17              // 会被排除

        fun test() {

            val myExclusionStrategy: ExclusionStrategy = object : ExclusionStrategy {
                override fun shouldSkipField(fa: FieldAttributes): Boolean {
                    return fa.getName().startsWith("_") // <---
                }

                override fun shouldSkipClass(clazz: Class<*>?): Boolean {
                    return false
                }
            }

            val gsonBuilder = GsonBuilder()
                .setExclusionStrategies(myExclusionStrategy)
                .create()

            val json = gsonBuilder.toJson(this)
            L.d(TAG, "排除字段-定制策略：$json")             // {"name":"小明"}
        }
    }


}