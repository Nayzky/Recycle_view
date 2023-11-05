package com.example.recycle_view

import android.os.Parcel
import android.os.Parcelable

data class Disaster(
    val nameDisaster: String="",
    val typeDisaster: String=""
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nameDisaster)
        parcel.writeString(typeDisaster)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Disaster> {
        override fun createFromParcel(parcel: Parcel): Disaster {
            return Disaster(parcel)
        }

        override fun newArray(size: Int): Array<Disaster?> {
            return arrayOfNulls(size)
        }
    }
}