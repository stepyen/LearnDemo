package com.stepyen.demo.androidmanifest.intent

import android.os.Parcel
import android.os.Parcelable

/**
 * date：6/3/21
 * author：stepyen
 * description：
 *
 */
class DemoParcelable {



    class User() : Parcelable {
        var name: String = ""
        var age: Int = 0

        constructor(parcel: Parcel) : this() {
            name = parcel.readString()
            age = parcel.readInt()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeInt(age)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<User> {
            override fun createFromParcel(parcel: Parcel): User {
                return User(parcel)
            }

            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls(size)
            }
        }

    }




}