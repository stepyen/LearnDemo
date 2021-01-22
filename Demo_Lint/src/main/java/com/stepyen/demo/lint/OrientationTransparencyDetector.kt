package com.stepyen.demo.lint

import com.android.SdkConstants
import com.android.tools.lint.detector.api.*
import org.w3c.dom.Attr
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import java.util.*


/**
 * date：2021/1/18
 * author：stepyen
 * description：
 *
 */
class OrientationTransparencyDetector : Detector(), XmlScanner {

    companion object {
        private val implementation: Implementation = Implementation(
            OrientationTransparencyDetector::class.java, EnumSet.of(
                Scope.MANIFEST,
                Scope.ALL_RESOURCE_FILES
            )
        )

        val issue = Issue.create(
            "OrientationTransparencyError",
            "不要在 AndroidManifest.xml 文件里同时设置方向和透明主题",
            "Activity 同时设置方向和透明主题在 Android 8.0 手机会 Crash",
            Category.CORRECTNESS,
            8,
            Severity.ERROR,
            implementation
        )

    }


    private val mThemeMap =  mutableMapOf<ElementEntity, String>()

    override fun visitElement(context: XmlContext, element: Element) {

        when (element.tagName) {
            SdkConstants.TAG_ACTIVITY -> if (isFixedOrientation(element)) {
                val theme = element.getAttributeNS(
                    SdkConstants.ANDROID_URI,
                    SdkConstants.ATTR_THEME
                )
                if ("@style/Theme.AppTheme" == theme) {
                    reportError(context, element)
                } else {
                    // 将主题设置暂存起来
                    mThemeMap[ElementEntity(context, element)] = theme.substring(theme.indexOf('/') + 1)
                }
            }
            SdkConstants.TAG_STYLE -> {
                val styleName = element.getAttribute(SdkConstants.ATTR_NAME)
                mThemeMap.forEach { (elementEntity: Any, theme: Any) ->
                    if (theme == styleName) {
                        if (isTranslucentOrFloating(element)) {
                            reportError(elementEntity.mContext, elementEntity.mElement)
                        } else if (element.hasAttribute(SdkConstants.ATTR_PARENT)) {
                            // 替换成父主题
                            mThemeMap[elementEntity] = element.getAttribute(SdkConstants.ATTR_PARENT)
                        }
                    }
                }
            }
            else -> {
            }
        }
    }

    override fun visitDocument(context: XmlContext, document: Document) {
        super.visitDocument(context, document)

    }


    override fun visitAttribute(context: XmlContext, attribute: Attr) {
        super.visitAttribute(context, attribute)

    }


    override fun getApplicableElements(): Collection<String>? {
        return mutableListOf(SdkConstants.TAG_ACTIVITY, SdkConstants.TAG_STYLE)
    }


    private fun isFixedOrientation(element: Element): Boolean {
        return when (element.getAttributeNS(SdkConstants.ANDROID_URI, "screenOrientation")) {
            "landscape",
            "sensorLandscape",
            "reverseLandscape",
            "userLandscape",
            "portrait",
            "sensorPortrait",
            "reversePortrait",
            "userPortrait",
            "locked" -> true
            else -> false
        }
    }

    private fun isTranslucentOrFloating(element: Element): Boolean {
        var child: Node? = element.firstChild
        while (child != null) {
            if (child is Element &&
                SdkConstants.TAG_ITEM == child.tagName &&
                child.getFirstChild() != null &&
                SdkConstants.VALUE_TRUE == child.getFirstChild().nodeValue
            ) {
                when ((child as Element).getAttribute(SdkConstants.ATTR_NAME)) {
                    "android:windowIsTranslucent",
                    "android:windowSwipeToDismiss",
                    "android:windowIsFloating" -> return true
                    else -> {
                    }
                }
            }
            child = child.nextSibling
        }
        return "Theme.AppTheme.Transparent" == element.getAttribute(SdkConstants.ATTR_PARENT)
    }


    private fun reportError(context: XmlContext, element: Element) {
        context.report(
            issue,
            element,
            context.getLocation(element),
            "请不要在 AndroidManifest.xml 文件里同时设置方向和透明主题"
        )
    }


    class ElementEntity(var mContext: XmlContext, var mElement: Element)
}