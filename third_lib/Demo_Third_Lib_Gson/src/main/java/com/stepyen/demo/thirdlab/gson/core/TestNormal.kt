package com.stepyen.demo.thirdlab.gson.core

import com.google.gson.*
import com.google.gson.annotations.SerializedName
import com.stepyen.demo.base.utils.L
import java.lang.reflect.Type


/**
 * date：6/2/21
 * author：stepyen
 * description：
 *
 */
class TestNormal {

    companion object {
        const val TAG = "test_normal_tag"
    }

    fun test() {
//        Normal().test()
        Normal2().test()
    }

    class Normal {
        @SerializedName("button_img")
        var buttonImg: String? = null
        var ident: String? = null

        fun test() {
            val json = """
                {
		"button_img": "https://pic.beta.baby-bus.com/",
		"ident": "12201"
	}
            """.trimIndent()

            L.d(TAG, "解析前：$json")
            val normalBean = Gson().fromJson<Normal>(json, Normal::class.java)

            L.d(TAG, "解析后：${Gson().toJson(normalBean)}")

        }
    }


    /**
     * 还没学会
     */
    class Normal2 {
        @SerializedName("sku")
        var ident: String? = null

        fun test() {
            val json = """
                {
                "name": "熟食区",
		"sku": "https://pic.beta.baby-bus.com/"

	}
            """.trimIndent()

            L.d(TAG, "解析前：$json")
//
//            val stringJsonSerializer: JsonSerializer<Normal2?> = object : JsonSerializer<Normal2?> {
//
//                override fun serialize(
//                    src: Normal2?,
//                    typeOfSrc: Type?,
//                    context: JsonSerializationContext?
//                ): JsonElement {
//
//                    val jsonPrimitive = src?.asJsonObject
//                    jsonPrimitive?.remove("sku")
//                    jsonPrimitive?.addProperty("ident", src?.ident)
//
//                    return jsonPrimitive
//                }
//            }
//            val gson: Gson = GsonBuilder()
//                .registerTypeAdapter(Normal2::class.java, stringJsonSerializer)
//                .create()
//
//            val normalBean = Gson().fromJson<Normal2>(json, Normal2::class.java)

//            L.d(TAG,"解析后：${Gson().toJson(normalBean)}")
//            L.d(TAG, "解析后：${gson.toJson(normalBean)}")

        }
    }


}