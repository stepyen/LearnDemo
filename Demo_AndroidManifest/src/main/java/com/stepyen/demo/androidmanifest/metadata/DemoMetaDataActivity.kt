package com.stepyen.demo.androidmanifest.metadata

import android.content.pm.PackageManager
import com.stepyen.demo.base.base.BasePageActivity
import com.stepyen.demo.base.utils.L

/**
 * date：2020/12/13
 * author：stepyen
 * description：
 *
 */
class DemoMetaDataActivity : BasePageActivity() {

    override var TAG: String = "MetaData_TAG"

    companion object {

    }

    override fun initView() {

        addButton("获取 Application级别 meta-data") {
            getApplicationMetaInfo()
        }

        addButton("获取 Activity级别 meta-data") {
            getActivityMetaInfo()
        }

        addButton("获取 Application级别 meta-data ManifestPlaceholders") {
            getApplicationMetaInfoManifestPlaceholders()
        }
    }


    /**
     * 获取 Application级别 MetaInfo
     *
     * 获取 value
     */
    private fun getApplicationMetaInfo() {
        var value: String? = ""

        try {

            val appInfo =
                packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
            value = appInfo.metaData.getString("application.test")

        } catch (e: PackageManager.NameNotFoundException) {

        }

        L.d(TAG, "Application MetaInfo value : $value")


    }

    /**
     * 获取 Activity 级别 MetaInfo
     *
     * 获取资源id
     */
    private fun getActivityMetaInfo() {
        var id: Int = 0

        try {

            val appInfo =
                packageManager.getActivityInfo(componentName, PackageManager.GET_META_DATA)
            id = appInfo.metaData.getInt("activity.test")

        } catch (e: PackageManager.NameNotFoundException) {

        }

        L.d(TAG, "Activity MetaInfo id : $id")
        try {
            L.d(TAG, "Activity MetaInfo id具体的值为 : ${getString(id)}")
        } catch (e: Exception) {

        }
    }


    /**
     * 获取 Application级别 MetaInfo
     * 具体值配置在 build.gradle#ManifestPlaceholders
     *
     * 获取 value
     */
    private fun getApplicationMetaInfoManifestPlaceholders() {
        var value: String? = ""

        try {

            val appInfo =
                packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
            value = appInfo.metaData.getString("application.test.manifestPlaceholders")

        } catch (e: PackageManager.NameNotFoundException) {

        }

        L.d(TAG, "Application MetaInfo value 配置在 ManifestPlaceholders  : $value")


    }
}
