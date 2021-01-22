package com.stepyen.demo.base.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * date：2020-02-12
 * author：stepyen
 * description：
 *
 */
@Parcelize
class PageBean3(val title:String, val cls:Class<*>? = null): Parcelable {
}